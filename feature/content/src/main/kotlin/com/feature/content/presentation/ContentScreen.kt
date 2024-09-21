package com.feature.content.presentation

import android.content.Intent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.screen.Screen
import com.core.ui.uiElements.mainScreenElements.MainBottomBar
import com.feature.player.PlayerActivity

object ContentScreen : Screen {
    @Composable
    override fun Content() {
        val context = LocalContext.current

        Scaffold(
            bottomBar = {
                MainBottomBar()
            }
        ) {
            Box(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    context.startActivity(Intent(context, PlayerActivity::class.java))
                }) {
                    Text(text = "Go to player")
                }
            }
        }
    }
}