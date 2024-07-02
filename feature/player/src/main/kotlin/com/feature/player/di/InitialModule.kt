package com.feature.player.di

import cafe.adriel.voyager.core.registry.screenModule
import com.alice.common.navigation.SharedScreen
import com.feature.player.PlayerScreen

val playerScreenModule = screenModule {
    register<SharedScreen.Player> {
        PlayerScreen()
    }
}