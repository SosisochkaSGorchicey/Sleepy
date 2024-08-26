package com.feature.content.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

object ContentScreen : Screen {
    @Composable
    override fun Content() {
        Text(text = "ContentScreen")
    }
}