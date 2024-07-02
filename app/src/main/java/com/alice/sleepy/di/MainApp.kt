package com.alice.sleepy.di

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.feature.initial.di.initialScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()

        ScreenRegistry {
            initialScreenModule()
        }

        startKoin {
            androidContext(this@MainApp)
            androidLogger()
            modules(
                listOf(

                )
            )
        }
    }
}