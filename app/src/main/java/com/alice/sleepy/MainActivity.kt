package com.alice.sleepy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import com.alice.common.navigation.SharedScreen
import com.alice.ui.theme.SleepyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            SleepyTheme {
                val loadingScreen = rememberScreen(provider = SharedScreen.Splash)
                Navigator(screen = loadingScreen)
            }
        }
    }
}