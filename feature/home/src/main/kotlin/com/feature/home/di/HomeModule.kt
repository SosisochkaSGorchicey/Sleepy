package com.feature.home.di

import cafe.adriel.voyager.core.registry.screenModule
import com.core.common.navigation.SharedScreen
import com.feature.home.presentation.HomeScreen
import com.feature.home.presentation.screenmodel.HomeScreenModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val homeScreenModule = screenModule {
    register<SharedScreen.HomeRoute> {
        HomeScreen
    }
}

val homeFeatureModule = module {
    factoryOf(::HomeScreenModel)
}