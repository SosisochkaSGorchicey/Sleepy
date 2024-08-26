package com.feature.notification.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

object NotificationScreen : Screen {
    @Composable
    override fun Content() {
        Text(text = "NotificationScreen")
    }
}