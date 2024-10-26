package com.feature.player.utils

sealed interface MediaStateEvents {
    data object PlayPause : MediaStateEvents
    data object SeekTo : MediaStateEvents
    data object Backward : MediaStateEvents
    data object Forward : MediaStateEvents
    data object Stop : MediaStateEvents
    data object SelectedMusicChange : MediaStateEvents
    data class MediaProgress(val progress: Float) : MediaStateEvents

}
