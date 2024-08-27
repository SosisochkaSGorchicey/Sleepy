package com.feature.notification.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.core.ui.uiElements.mainScreenElements.MainBottomBar

object NotificationScreen : Screen {
    @Composable
    override fun Content() {
        Scaffold(
            bottomBar = {
                MainBottomBar()
            }
        ) {
            Text(text = "NotificationScreen")
        }
    }
}