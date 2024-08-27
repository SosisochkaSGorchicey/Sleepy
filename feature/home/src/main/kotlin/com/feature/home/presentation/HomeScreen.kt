package com.feature.home.presentation

import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.core.ui.uiElements.mainScreenElements.MainBottomBar

object HomeScreen : Screen {
    @Composable
    override fun Content() { //todo
        Scaffold(
            bottomBar = {
                MainBottomBar()
            }
        ) {
            Text(text = "HomeScreen")
        }
    }
}