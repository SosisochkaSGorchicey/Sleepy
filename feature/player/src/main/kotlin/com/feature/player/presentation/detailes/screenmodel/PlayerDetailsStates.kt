package com.feature.player.presentation.detailes.screenmodel

import androidx.compose.runtime.Immutable
import com.core.domain.model.supabase.db.AudioDataItem
import com.core.domain.model.supabase.db.AudioItem

@Immutable
data class PlayerDetailsState(
    val duration: Long = 0L,
    val progress: Float = 0f,
    val isMusicPlaying: Boolean = false,
    val currentAudioDataItem: AudioDataItem = AudioDataItem(),
    val musicItem: AudioItem = AudioItem(),
    val playerDetailsUIState: PlayerDetailsUIState = PlayerDetailsUIState.InitialHome,
    val isLoading: Boolean = false,
    val isConnectionError: Boolean = false,
)

sealed interface PlayerDetailsEvent {
    data object OnBackClick : PlayerDetailsEvent
    data object PlayPause : PlayerDetailsEvent
    data class CurrentAudioChanged(val index: Int) : PlayerDetailsEvent
    data class SeekTo(val position: Float) : PlayerDetailsEvent
    data class UpdateProgress(val progress: Float) : PlayerDetailsEvent
    data class InitCurrentAudio(val audioDataItem: AudioDataItem) : PlayerDetailsEvent
}

sealed interface PlayerDetailsSideEffect {
    data object NavigateBack : PlayerDetailsSideEffect
}