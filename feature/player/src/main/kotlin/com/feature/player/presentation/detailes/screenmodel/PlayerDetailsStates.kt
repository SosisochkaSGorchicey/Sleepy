package com.feature.player.presentation.detailes.screenmodel

import androidx.compose.runtime.Immutable
import com.core.domain.model.AudioItem

@Immutable
data class PlayerDetailsState(
    val duration: Long = 0L,
    val progress: Float = 0f,
    val progressValue: String = "00:00",
    val isMusicPlaying: Boolean = false,
    val currentSelectedMusic: AudioItem = AudioItem(),
    val musicList: List<AudioItem> = emptyList(),
    val playerDetailsUIState: PlayerDetailsUIState = PlayerDetailsUIState.InitialHome,
)

sealed interface PlayerDetailsEvent {
    data object OnBackClick : PlayerDetailsEvent
    data object PlayPause : PlayerDetailsEvent
    data class CurrentAudioChanged(val index: Int) : PlayerDetailsEvent
    data class SeekTo(val position: Float) : PlayerDetailsEvent
    data class UpdateProgress(val progress: Float) : PlayerDetailsEvent
    data object Backward : PlayerDetailsEvent
    data object Forward : PlayerDetailsEvent
}

sealed interface PlayerDetailsSideEffect {
    data object NavigateBack : PlayerDetailsSideEffect
}