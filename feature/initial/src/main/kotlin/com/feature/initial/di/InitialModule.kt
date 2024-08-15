package com.feature.initial.di

import cafe.adriel.voyager.core.registry.screenModule
import com.core.common.navigation.SharedScreen
import com.feature.initial.splash.SplashScreen
import com.feature.initial.splash.screenmodel.SplashScreenModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val initialScreenModule = screenModule {
    register<SharedScreen.Splash> {
        SplashScreen()
    }
}

val initialModule = module {
    factoryOf(::SplashScreenModel)
}