package com.feature.audioContent.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.feature.audioContent.presentation.screenmodel.AudioContentState

@Composable
fun AudioContentScreenUI(
    modifier: Modifier,
    state: AudioContentState
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item { Header() }

        items(state.audioContent) {
            Text("cdsvsd")
        }
    }
}