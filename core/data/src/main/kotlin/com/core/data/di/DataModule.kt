package com.core.data.di

import com.core.data.BuildConfig
import com.core.data.repository.SupabaseAuthRepositoryImpl
import com.core.domain.repository.SupabaseAuthRepository
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.FlowType
import io.github.jan.supabase.gotrue.auth
import io.github.jan.supabase.postgrest.Postgrest
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    singleOf(::SupabaseAuthRepositoryImpl) bind SupabaseAuthRepository::class

    singleOf(::provideSupabaseClient)
    singleOf(::provideSupabaseAuth)
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