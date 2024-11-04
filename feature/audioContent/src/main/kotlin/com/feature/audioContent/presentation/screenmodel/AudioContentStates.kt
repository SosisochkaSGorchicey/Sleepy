package com.feature.audioContent.presentation.screenmodel

import androidx.compose.runtime.Immutable

@Immutable
data class AudioContentState( //todo

    val inLoading: Boolean = true,

    )

sealed interface AudioContentEvent {

}

sealed interface AudioContentSideEffect {

}