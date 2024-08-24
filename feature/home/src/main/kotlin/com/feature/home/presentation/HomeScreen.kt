package com.feature.home.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.core.ui.uiElements.CustomScaffoldWithBottomBar

object HomeScreen : Screen {
    @Composable
    override fun Content() { //todo



        CustomScaffoldWithBottomBar {
            LazyColumn {
                items(1000) {
                    Text(text = it.toString())
                }
            }
        }
    }
}