package com.simple.mobile.sleepy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.core.common.navigation.SharedScreen
import com.core.ui.theme.AppTheme
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(scrim = 0),
            navigationBarStyle = SystemBarStyle.dark(scrim = 0)
        )

        setContent {
            AppTheme {
                val loadingScreen = rememberScreen(provider = SharedScreen.Splash)
                Navigator(screen = loadingScreen) {
                    SlideTransition(navigator = it)
                }
            }
        }
    }
}