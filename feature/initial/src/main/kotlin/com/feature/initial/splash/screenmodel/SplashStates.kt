package com.feature.initial.splash.screenmodel

import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable

@Immutable
data class SplashState(
    @StringRes val errorTextRes: Int? = null
)

sealed interface SplashSideEffect {
    data object NavigateToAuth : SplashSideEffect
    data object NavigateToHome : SplashSideEffect
}