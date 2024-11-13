package com.feature.player.utils

sealed interface MusicStates {
    data object Initial : MusicStates
    data class MediaBuffering(val progress: Long) : MusicStates
    data class MediaReady(val duration: Long) : MusicStates
    data class MediaProgress(val progress: Long) : MusicStates
    data class MediaPlaying(val isPlaying: Boolean) : MusicStates
}
