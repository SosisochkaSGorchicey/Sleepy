package com.feature.player.presentation.detailes.screenmodel

sealed interface PlayerDetailsUIState {
    data object InitialHome : PlayerDetailsUIState
    data object HomeReady : PlayerDetailsUIState
}
