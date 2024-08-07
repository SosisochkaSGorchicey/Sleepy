package com.alice.sleepy.di

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.feature.auth.di.authModule
import com.feature.auth.di.authScreenModule
import com.feature.initial.di.initialModule
import com.feature.initial.di.initialScreenModule
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
        }

        startKoin {
            androidContext(this@MainApp)
            androidLogger()
            modules(
                listOf(
                    playerModule,
                    initialModule,
                    authModule
                )
            )
        }
    }
}