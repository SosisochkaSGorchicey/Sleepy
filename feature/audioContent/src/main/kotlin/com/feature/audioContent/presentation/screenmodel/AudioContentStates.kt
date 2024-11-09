package com.feature.audioContent.presentation.screenmodel

import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import com.core.domain.model.AudioSection

@Immutable
data class AudioContentState(
    val audioContent: List<AudioSection> = emptyList(),
    val inLoading: Boolean = true,
    @StringRes val errorTextRes: Int? = null
)

sealed interface AudioContentEvent {
    data object ReloadData : AudioContentEvent
    data object OnItemClick: AudioContentEvent
}

sealed interface AudioContentSideEffect {
    data object NavigateToDetailScreen: AudioContentSideEffect
}