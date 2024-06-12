package com.alice.common.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen: ScreenProvider {
    data object Splash : SharedScreen()
}