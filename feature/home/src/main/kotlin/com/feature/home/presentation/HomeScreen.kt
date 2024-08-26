package com.feature.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import com.core.ui.uiElements.mainScreenElements.MainBottomBar

object HomeScreen : Screen {
    @Composable
    override fun Content() { //todo
        val navigator = LocalNavigator.currentOrThrow
        val localTabNavigator = LocalTabNavigator.current
        println("TAG: HomeScreen navigator $navigator")
        println("TAG: HomeScreen localTabNavigator $localTabNavigator")
        println("TAG: HomeScreen navigator parent ${navigator.parent}")

        Scaffold(
            bottomBar = {
                MainBottomBar()
            }
        ) {
            Column {

                Button(onClick = { navigator.push(TestScreen) }) {
                    Text(text = "Go")
                }


                Button(onClick = { navigator.parent?.push(TestScreen) }) {
                    Text(text = "Go")
                }
            }
        }
    }
}