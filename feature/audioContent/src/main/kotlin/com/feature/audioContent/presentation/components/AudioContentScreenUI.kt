package com.feature.audioContent.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.feature.audioContent.presentation.screenmodel.AudioContentEvent
import com.feature.audioContent.presentation.screenmodel.AudioContentState

@Composable
fun AudioContentScreenUI(
    modifier: Modifier,
    lastItemModifier: Modifier,
    state: AudioContentState,
    onEvent: (AudioContentEvent) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item { Header() }

        if (!state.inLoading && state.errorTextRes == null)
            item { SleepSounds() }

        itemsIndexed(state.audioContent) { index, audioSection ->
            SectionUI(
                audioSection = audioSection,
                modifier = index.toBottomModifier(
                    list = state.audioContent,
                    modifier = lastItemModifier
                ),
                onEvent = onEvent
            )
        }
    }
}