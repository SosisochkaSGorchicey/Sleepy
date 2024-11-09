package com.feature.player.presentation.detailes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import com.feature.player.presentation.detailes.components.DetailsScreenUI
import com.feature.player.presentation.detailes.screenmodel.PlayerDetailsEvent
import com.feature.player.presentation.detailes.screenmodel.PlayerDetailsScreenModel
import org.orbitmvi.orbit.compose.collectAsState


class DetailsScreen(private val audioUrl: String) : Screen {
    @Composable
    override fun Content() {
        val viewModel = getScreenModel<PlayerDetailsScreenModel>()
        val state = viewModel.collectAsState().value

        LaunchedEffect(key1 = Unit) {
            viewModel.onEvent(PlayerDetailsEvent.InitCurrentAudio(audioUrl))
        }

        DetailsScreenUI(
            state = state,
            onEvent = viewModel::onEvent
        )
    }
}

