package com.feature.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.core.ui.uiElements.mainScreenElements.MainBottomBar

object HomeScreen : Screen {
    @Composable
    override fun Content() { //todo
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            bottomBar = {
                MainBottomBar()
            }
        ) {
            Column {

                Button(onClick = { navigator.push(TestScreen) }) {
                    Text(text = "Go")
                }
            }
        }
    }
}