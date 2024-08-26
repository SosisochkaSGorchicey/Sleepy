package com.core.sleepy

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.registry.screenModule
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.NavigatorDisposeBehavior
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.core.common.navigation.SharedScreen
import com.core.ui.theme.AppTheme
import com.core.ui.uiElements.mainScreenElements.HomeTab
import com.core.ui.uiElements.mainScreenElements.MainBottomBar

object TabGraph : Screen {
    @Composable
    override fun Content() {
//        Navigator(
//            screen = HomeTab,
//            disposeBehavior = NavigatorDisposeBehavior(
//                disposeNestedNavigators = false,
//                disposeSteps = false
//            ),
//            onBackPressed = null,
//            key = key
//        ) { navigator ->
//            val tabNavigator = remember(navigator) {
//                TabNavigator(navigator)
//            }
//
//            //tabDisposable?.invoke(tabNavigator)
//
//            CompositionLocalProvider(LocalTabNavigator provides tabNavigator) {
//                content(tabNavigator)
//            }
//        }


        TabNavigator(
            HomeTab,
            disposeNestedNavigators = true
        ) {
            CurrentTab()
//            Scaffold(
//                bottomBar = { MainBottomBar() },
//                containerColor = AppTheme.colors.transparent
//            ) {
//                Box(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(bottom = it.calculateBottomPadding())
//                ) {
//                    CurrentTab()
//                }
//            }
        }
    }
}

val tabGraphScreen = screenModule {
    register<SharedScreen.TabGraphScreen> {
        TabGraph
    }
}
