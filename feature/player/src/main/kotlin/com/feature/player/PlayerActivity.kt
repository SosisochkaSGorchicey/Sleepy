package com.feature.player

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.core.ui.theme.AppTheme
import com.feature.player.presentation.detailes.DetailsScreen
import com.feature.player.service.PlaybackService


class PlayerActivity : ComponentActivity() {
    private var isServiceRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startMusicService()

        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(scrim = 0),
            navigationBarStyle = SystemBarStyle.dark(scrim = 0)
        )

        setContent {
            AppTheme {
                Navigator(screen = DetailsScreen) {
                    SlideTransition(navigator = it)
                }
            }
        }
    }

    private fun startMusicService() {
        if (!isServiceRunning) {
            val intent = Intent(this, PlaybackService::class.java)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) startForegroundService(intent)
            else startService(intent)

            isServiceRunning = true
        }
    }
}
