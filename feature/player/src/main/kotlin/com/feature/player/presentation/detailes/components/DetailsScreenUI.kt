package com.feature.player.presentation.detailes.components

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
import androidx.compose.ui.unit.dp
import com.core.ui.theme.AppTheme
import com.core.ui.uiElements.mainScreenElements.SimpleBackIcon
import com.core.ui.uiElements.mainScreenElements.SimpleTopBar
import com.feature.player.presentation.detailes.screenmodel.PlayerDetailsEvent
import com.feature.player.presentation.detailes.screenmodel.PlayerDetailsState

@Composable
fun DetailsScreenUI(
    state: PlayerDetailsState,
    onEvent: (PlayerDetailsEvent) -> Unit
) {
    Scaffold(
        containerColor = AppTheme.colors.baseBlueLight,
        contentColor = AppTheme.colors.black,
        topBar = {
            SimpleTopBar(
                navigationIcon = {
                    SimpleBackIcon(
                        onClick = {}
                    )
                },
                titleText = "Name of item"
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(top = 10.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainDetailsUI()
            PlayerButton(
                onPlayStop = { onEvent(PlayerDetailsEvent.PlayPause) },
                onSelect = { onEvent(PlayerDetailsEvent.CurrentAudioChanged(1)) }
            )
            TextDescription()
        }
    }
}