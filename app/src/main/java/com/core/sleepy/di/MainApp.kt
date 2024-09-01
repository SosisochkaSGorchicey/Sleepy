package com.core.sleepy.di

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.core.data.di.dataModule
import com.core.domain.di.domainModule
import com.core.domain.repository.DataStoreRepository
import com.core.sleepy.tabGraphScreen
import com.feature.auth.di.authModule
import com.feature.auth.di.authScreenModule
import com.feature.content.di.contentScreenModule
import com.feature.home.di.homeFeatureModule
import com.feature.home.di.homeScreenModule
import com.feature.initial.di.initialModule
import com.feature.initial.di.initialScreenModule
import com.feature.notification.di.notificationScreenModule
import com.feature.player.di.playerModule
import com.feature.player.di.playerScreenModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()

        ScreenRegistry {
            initialScreenModule()
            authScreenModule()
            playerScreenModule()
            homeScreenModule()
            contentScreenModule()
            notificationScreenModule()
            tabGraphScreen()
        }

        startKoin {
            androidContext(this@MainApp)
            androidLogger()
            modules(
                listOf(
                    playerModule,
                    initialModule,
                    authModule,
                    dataModule,
                    domainModule,
                    homeFeatureModule
                )
            )
        }

        val datastore: DataStoreRepository by inject()
    }
}