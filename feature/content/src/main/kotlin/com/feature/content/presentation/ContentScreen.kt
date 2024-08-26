package com.feature.content.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.core.ui.uiElements.mainScreenElements.MainBottomBar

object ContentScreen : Screen {
    @Composable
    override fun Content() {

        Scaffold(
            bottomBar = {
                MainBottomBar()
            }
        ) {
            Column {

                Text(text = "ContentScreen")
            }
        }


    }
}