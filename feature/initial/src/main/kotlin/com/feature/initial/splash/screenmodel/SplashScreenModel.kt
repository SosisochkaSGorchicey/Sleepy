package com.feature.initial.splash.screenmodel

import com.core.common.mvi.MviScreenMode
import com.core.common.mvi.emitSideEffect
import com.core.domain.model.supabaseAuth.LoggedInState
import com.core.domain.repository.SupabaseAuthRepository
import com.feature.initial.splash.toTextRes
import kotlinx.coroutines.delay
import org.orbitmvi.orbit.syntax.simple.intent

class SplashScreenModel(
    private val supabaseAuthRepository: SupabaseAuthRepository
) : MviScreenMode<Any, SplashSideEffect, Any>(
    initialState = Unit
) {

    init {
        decideNavigation()
    }


    private fun decideNavigation() = intent {
        delay(3000) //todo?
        supabaseAuthRepository.isUserLoggedIn().collect {
            when {
                it is LoggedInState.Error -> {
                    // TODO show error
                    println("TAG: decideNavigation ${it.supabaseResult.errorType.toTextRes()}")
                }

                it is LoggedInState.LoggedIn -> emitSideEffect(SplashSideEffect.NavigateToHome)
                it is LoggedInState.NotLoggedIn -> emitSideEffect(SplashSideEffect.NavigateToAuth)
            }
        }
    }

    override fun onEvent(event: Any) {

    }
}