package com.feature.initial.splash.screenmodel

import com.alice.common.mvi.MviScreenMode
import kotlinx.coroutines.delay
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect

class SplashScreenModel : MviScreenMode<Any, SplashSideEffect, Any>(
    initialState = Unit
) {

    init {
        intent { //todo later
            delay(3000)
            postSideEffect(SplashSideEffect.NavigateToAuth)
        }
    }

    override fun onEvent(event: Any) {

    }
}