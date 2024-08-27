package com.feature.home.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.core.ui.theme.AppTheme
import com.core.ui.uiElements.mainScreenElements.AccountIcon
import com.core.ui.uiElements.mainScreenElements.MainBottomBar
import com.core.ui.uiElements.mainScreenElements.MainTopBar
import com.core.ui.uiElements.mainScreenElements.SettingsIcon

object HomeScreen : Screen {
    @Composable
    override fun Content() { //todo
        Scaffold(
            containerColor = AppTheme.colors.baseBlueLight,
            bottomBar = {
                MainBottomBar()
            },
            topBar = {
                MainTopBar(
                    titleText = "Hello, Alice!", //todo
                    navigationIcon = {
                        SettingsIcon(onClick = {})
                    },
                    actions = {
                        AccountIcon(onClick = {})
                    }
                )
            }
        ) {

        }
    }
}