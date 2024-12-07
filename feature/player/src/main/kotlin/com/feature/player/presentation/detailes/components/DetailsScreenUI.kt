package com.feature.player.presentation.detailes.components

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.core.ui.R
import com.core.ui.theme.AppTheme
import com.core.ui.uiElements.ErrorSnackbar
import com.core.ui.uiElements.LoadingDisplay
import com.core.ui.uiElements.mainScreenElements.SimpleBackIcon
import com.core.ui.uiElements.mainScreenElements.SimpleTopBar
import com.feature.player.presentation.detailes.screenmodel.PlayerDetailsEvent
import com.feature.player.presentation.detailes.screenmodel.PlayerDetailsState
import com.feature.player.service.PlaybackService

@Composable
fun DetailsScreenUI(
    state: PlayerDetailsState,
    onEvent: (PlayerDetailsEvent) -> Unit
) {

    val context = LocalContext.current

    Scaffold(
        containerColor = AppTheme.colors.baseBlueLight,
        contentColor = AppTheme.colors.black,
        topBar = {
            SimpleTopBar(
                navigationIcon = {
                    SimpleBackIcon(
                        onClick = { onEvent(PlayerDetailsEvent.OnBackClick) }
                    )
                },
                titleText = state.currentAudioDataItem.name,
                modifier = Modifier.padding(top = 20.dp)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(top = 10.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainDetailsUI(
                state = state,
                onProgressCallback = { onEvent(PlayerDetailsEvent.SeekTo(it)) }
            )

            PlayerButton(
                onPlayStop = { onEvent(PlayerDetailsEvent.PlayPause) },
                onSelect = {
                    if (!state.isMusicPlaying) {
                        val intent = Intent(context, PlaybackService::class.java)
                        context.startService(intent)
                    }

                    onEvent(PlayerDetailsEvent.CurrentAudioChanged(1))
                },
                isPlaying = state.isMusicPlaying
            )

            TextDescription()
        }

        if (state.isLoading) LoadingDisplay(
            layoutModifier = Modifier.padding(paddingValues)
        )

        if (state.isConnectionError) ErrorSnackbar(
            modifier = Modifier.padding(paddingValues),
            errorTextRes = R.string.error_unknown
        )
    }
}