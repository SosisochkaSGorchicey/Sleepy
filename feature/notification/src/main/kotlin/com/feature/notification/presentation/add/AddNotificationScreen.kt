package com.feature.notification.presentation.add

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.feature.notification.presentation.add.components.AddNotificationScreenUI

object AddNotificationScreen: Screen {
    @Composable
    override fun Content() {
        AddNotificationScreenUI()
    }
}