package com.feature.content.di

import cafe.adriel.voyager.core.registry.screenModule
import com.core.common.navigation.SharedScreen
import com.feature.content.presentation.ContentScreen

val contentScreenModule = screenModule {
    register<SharedScreen.ContentRoute> {
        ContentScreen
    }
}