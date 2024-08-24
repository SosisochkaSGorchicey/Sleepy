package com.feature.initial.splash.screenmodel

import com.core.common.mvi.MviScreenMode
import com.core.common.mvi.emitSideEffect
import com.core.common.mvi.reducer
import com.core.domain.model.supabaseAuth.LoggedInState
import com.core.domain.usecase.IsUserLoggedInUseCase
import com.feature.initial.splash.toTextRes
import kotlinx.coroutines.delay
import org.orbitmvi.orbit.syntax.simple.intent

class SplashScreenModel(
    private val isUserLoggedInUseCase: IsUserLoggedInUseCase
) : MviScreenMode<SplashState, SplashSideEffect, SplashEvent>(
    initialState = SplashState()
) {

    init {
        decideNavigation()
    }

    override fun onEvent(event: SplashEvent) {
        when (event) {
            SplashEvent.DecideNavigation -> decideNavigation()
        }
    }

    private fun decideNavigation() = intent {
        delay(3000) //todo?
        isUserLoggedInUseCase().collect {
            println("TAG: decideNavigation $it")

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