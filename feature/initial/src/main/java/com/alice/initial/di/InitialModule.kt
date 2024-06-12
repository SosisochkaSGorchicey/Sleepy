package com.alice.initial.di

import cafe.adriel.voyager.core.registry.screenModule
import com.alice.common.navigation.SharedScreen
import com.alice.initial.splash.SplashScreen

val initialScreenModule = screenModule {
    register<SharedScreen.Splash> {
        SplashScreen()
    }
}