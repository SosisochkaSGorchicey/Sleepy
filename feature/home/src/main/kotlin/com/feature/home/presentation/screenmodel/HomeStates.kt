package com.feature.home.presentation.screenmodel

import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable

@Immutable
data class HomeState(
    @StringRes val errorTextRes: Int? = null
)

sealed interface HomeEvent {
    data object OnAccountClick : HomeEvent
    data object OnSettingsClick : HomeEvent
}

sealed interface HomeSideEffect {
    data object NavigateToAccount: HomeSideEffect
    data object NavigateToSettings: HomeSideEffect
}