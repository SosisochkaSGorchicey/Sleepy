package com.core.sleepy

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.registry.screenModule
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.core.common.navigation.SharedScreen
import com.core.ui.uiElements.mainScreenElements.HomeTab

object TabGraph : Screen {
    @Composable
    override fun Content() {
        TabNavigator(
            tab = HomeTab,
            disposeNestedNavigators = true
        ) {
            CurrentTab()
        }
    }
}

val tabGraphScreen = screenModule {
    register<SharedScreen.TabGraphScreen> {
        TabGraph
    }
}
