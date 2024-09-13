package com.feature.initial.splash.screenmodel

import com.core.common.mvi.MviScreenModel
import com.core.common.mvi.emitSideEffect
import com.core.common.mvi.reducer
import com.core.domain.model.supabase.LoggedInState
import com.core.domain.usecase.IsUserLoggedInUseCase
import com.feature.initial.splash.toTextRes
import kotlinx.coroutines.delay
import org.orbitmvi.orbit.syntax.simple.intent

class SplashScreenModel(
    private val isUserLoggedInUseCase: IsUserLoggedInUseCase
) : MviScreenModel<SplashState, SplashSideEffect, SplashEvent>(
    initialState = SplashState()
) {

    init {
        //decideNavigation() todo
        emitSideEffect(SplashSideEffect.NavigateToHome)
    }

    override fun onEvent(event: SplashEvent) {
        when (event) {
            SplashEvent.DecideNavigation -> decideNavigation()
        }
    }

    private fun decideNavigation() = intent {
        delay(500) //todo?
        isUserLoggedInUseCase().collect {
            when {
                it is LoggedInState.Error -> {
                    showError(errorTextRes = it.supabaseResult.errorType.toTextRes())
                }

                it is LoggedInState.LoggedIn -> emitSideEffect(SplashSideEffect.NavigateToHome)
                it is LoggedInState.NotLoggedIn -> emitSideEffect(SplashSideEffect.NavigateToAuth)
            }
        }
    }

    private fun showError(errorTextRes: Int) = reducer {
        state.copy(errorTextRes = errorTextRes)
    }
}