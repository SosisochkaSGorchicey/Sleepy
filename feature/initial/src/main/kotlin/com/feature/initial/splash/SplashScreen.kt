package com.feature.initial.splash

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import com.feature.initial.splash.content.SplashScreenContent


class SplashScreen : Screen {
    @Composable
    override fun Content() {
        Scaffold { padding ->
            SplashScreenContent(
                modifier = Modifier.padding(padding)
            )
        }
    }
}