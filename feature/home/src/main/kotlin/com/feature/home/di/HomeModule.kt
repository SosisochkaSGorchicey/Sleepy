package com.feature.home.di

import cafe.adriel.voyager.core.registry.screenModule
import com.core.common.navigation.SharedScreen
import com.feature.home.presentation.HomeScreen

val homeScreenModule = screenModule {
    register<SharedScreen.Home> {
        HomeScreen
    }
}