package com.simple.mobile.sleepy.di

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.core.data.di.dataModule
import com.core.database.di.databaseModule
import com.core.domain.di.domainModule
import com.simple.mobile.sleepy.tabGraphScreen
import com.feature.audioContent.di.contentFeatureModule
import com.feature.auth.di.authModule
import com.feature.auth.di.authScreenModule
import com.feature.audioContent.di.contentScreenModule
import com.feature.home.di.homeFeatureModule
import com.feature.home.di.homeScreenModule
import com.feature.initial.di.initialModule
import com.feature.initial.di.initialScreenModule
import com.feature.notification.di.notificationFeatureModule
import com.feature.notification.di.notificationScreenModule
import com.feature.player.di.playerModule
import com.feature.player.di.playerScreenModule
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
                    homeFeatureModule,
                    contentFeatureModule,
                    notificationFeatureModule,
                    databaseModule
                )
            )
        }
    }
}