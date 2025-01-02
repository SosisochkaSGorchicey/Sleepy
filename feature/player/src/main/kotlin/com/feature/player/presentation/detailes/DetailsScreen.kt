package com.feature.player.presentation.detailes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.core.domain.model.supabase.db.AudioDataItem
import com.feature.player.presentation.detailes.components.DetailsScreenUI
import com.feature.player.presentation.detailes.screenmodel.PlayerDetailsEvent
import com.feature.player.presentation.detailes.screenmodel.PlayerDetailsScreenModel
import com.feature.player.presentation.detailes.screenmodel.PlayerDetailsSideEffect
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect


class DetailsScreen(
    private val imageRes: String,
    private val audioUrl: String,
    private val name: String,
    private val tag: String,
    private val minutesDuration: Int,
) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<PlayerDetailsScreenModel>()
        val state = viewModel.collectAsState().value

        LaunchedEffect(key1 = Unit) {
            viewModel.onEvent(
                PlayerDetailsEvent.InitCurrentAudio(
                    audioDataItem = AudioDataItem(
                        imageRes = imageRes,
                        audioUrl = audioUrl,
                        minutesDuration = minutesDuration,
                        name = name,
                        tag = tag
                    )
                )
            )
        }

        DetailsScreenUI(
            state = state,
            onEvent = viewModel::onEvent
        )

        viewModel.collectSideEffect { sideEffect ->
            when (sideEffect) {
                PlayerDetailsSideEffect.NavigateBack -> navigator.pop()
            }
        }
    }
}

