package com.alice.common.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.screen.Screen

sealed interface SharedScreen : ScreenProvider {
    data object Splash : SharedScreen
    data object LogIn : SharedScreen
    data object Home : SharedScreen
    data object Player : SharedScreen
}

fun SharedScreen.screen(): Screen = ScreenRegistry.get(this)