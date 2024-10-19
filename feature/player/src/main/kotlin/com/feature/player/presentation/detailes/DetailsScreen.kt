package com.feature.player.presentation.detailes

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.feature.player.presentation.detailes.components.DetailsScreenUI

object DetailsScreen: Screen {
    @Composable
    override fun Content() {
        DetailsScreenUI()
    }
}