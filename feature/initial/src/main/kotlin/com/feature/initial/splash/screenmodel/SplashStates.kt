package com.feature.initial.splash.screenmodel

sealed interface SplashSideEffect {
    data object NavigateToAuth : SplashSideEffect
    data object NavigateToHome : SplashSideEffect
}