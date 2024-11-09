package com.feature.player.presentation.detailes

import android.app.ActivityManager
import android.content.Context
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.feature.player.presentation.detailes.components.DetailsScreenUI
import com.feature.player.presentation.detailes.screenmodel.PlayerDetailsScreenModel
import org.orbitmvi.orbit.compose.collectAsState


object DetailsScreen: Screen {
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<PlayerDetailsScreenModel>()
        val state = viewModel.collectAsState().value

        DetailsScreenUI(
            state = state,
            onEvent = viewModel::onEvent
        )
    }
}

