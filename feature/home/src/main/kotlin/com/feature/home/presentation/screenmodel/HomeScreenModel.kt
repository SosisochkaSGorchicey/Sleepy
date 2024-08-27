package com.feature.home.presentation.screenmodel

import com.core.common.mvi.MviScreenModel
import com.core.common.mvi.emitSideEffect

class HomeScreenModel : MviScreenModel<HomeState, HomeSideEffect, HomeEvent>(
    initialState = HomeState()
) {
    override fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.OnAccountClick -> emitSideEffect(HomeSideEffect.NavigateToAccount)
            HomeEvent.OnSettingsClick -> emitSideEffect(HomeSideEffect.NavigateToSettings)
        }
    }
}