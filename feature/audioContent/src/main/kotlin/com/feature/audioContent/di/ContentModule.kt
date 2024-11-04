package com.feature.audioContent.di

import cafe.adriel.voyager.core.registry.screenModule
import com.core.common.navigation.SharedScreen
import com.feature.audioContent.presentation.AudioContentScreen
import com.feature.audioContent.presentation.screenmodel.AudioContentScreenModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val contentScreenModule = screenModule {
    register<SharedScreen.ContentRoute> {
        AudioContentScreen
    }
}

val contentFeatureModule = module {
    factoryOf(::AudioContentScreenModel)
}