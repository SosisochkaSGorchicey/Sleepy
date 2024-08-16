package com.core.data.di

import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.core.data.BuildConfig
import com.core.data.repository.DataStoreRepositoryImpl
import com.core.data.repository.SupabaseAuthRepositoryImpl
import com.core.domain.repository.DataStoreRepository
import com.core.domain.repository.SupabaseAuthRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.FlowType
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.Postgrest
import org.koin.android.ext.koin.androidApplication
import org.koin.core.definition.KoinDefinition
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    provideDataStorePref()

    singleOf(::SupabaseAuthRepositoryImpl) bind SupabaseAuthRepository::class
    singleOf(::DataStoreRepositoryImpl) bind DataStoreRepository::class

    singleOf(::provideSupabaseClient)
    singleOf(::provideSupabaseAuth)
}

internal fun Module.provideDataStorePref(): KoinDefinition<DataStore<Preferences>> = single {
    PreferenceDataStoreFactory.create(
        corruptionHandler = ReplaceFileCorruptionHandler(
            produceNewData = { emptyPreferences() }
        ),
        produceFile = {
            androidApplication().preferencesDataStoreFile("preferences_data_store")
        }
    )
}

private fun provideSupabaseClient(): SupabaseClient {
    return createSupabaseClient(
        supabaseUrl = BuildConfig.SUPABASE_URL,
        supabaseKey = BuildConfig.SUPABASE_SECRET_KEY
    ) {
        install(Auth) {
            flowType = FlowType.PKCE
            scheme = "app"
            host = "supabase.com"
            autoSaveToStorage = true
            autoLoadFromStorage = true
            alwaysAutoRefresh = true
        }
        install(Postgrest)
    }
}

private fun provideSupabaseAuth(client: SupabaseClient): Auth = client.auth