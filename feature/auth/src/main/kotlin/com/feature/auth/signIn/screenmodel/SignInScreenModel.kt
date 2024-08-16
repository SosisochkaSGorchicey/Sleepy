package com.feature.auth.signIn.screenmodel

import com.core.common.mvi.MviScreenMode
import com.core.common.mvi.blockingReducer
import com.core.common.mvi.emitSideEffect
import com.core.common.mvi.reducer
import com.core.domain.model.SupabaseResult
import com.core.domain.usecase.SignInUseCase
import com.core.domain.usecase.SignUpAnonymously
import com.feature.auth.utils.toTextRes
import kotlinx.coroutines.delay
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class SignInScreenModel(
    private val signInUseCase: SignInUseCase,
    private val signUpAnonymously: SignUpAnonymously
) : MviScreenMode<SignInState, SignInSideEffect, SignInEvent>(
    initialState = SignInState()
) {
    override fun onEvent(event: SignInEvent) {
        when (event) {
            SignInEvent.OnAnonymousClick -> signInAnonymously()
            is SignInEvent.OnEmailChange -> changeEmail(newValue = event.newValue)
            is SignInEvent.OnPasswordChange -> changePassword(newValue = event.newValue)
            SignInEvent.OnSignInClick -> signIn()
            SignInEvent.OnSignUpClick -> goToSignUp()
        }
    }

    private fun signInAnonymously() = intent {
        signUpAnonymously().collect { supabaseResult ->
            supabaseResult.observe()
        }
    }

    private fun signIn() = intent {
        signInUseCase(
            email = state.logInData.email.first,
            password = state.logInData.password.first
        ).collect { supabaseResult ->
            supabaseResult.observe()
        }
    }

    private fun goToSignUp() =
        emitSideEffect(SignInSideEffect.NavigateToSignUpScreen)

    private fun changeEmail(
        newValue: String,
        isError: Int? = null
    ) = blockingReducer {
        state.copy(
            logInData = state.logInData.copy(
                email = state.logInData.email.copy(
                    first = newValue,
                    second = isError
                )
            )
        )
    }

    private fun changePassword(
        newValue: String,
        isError: Int? = null
    ) = blockingReducer {
        state.copy(
            logInData = state.logInData.copy(
                password = state.logInData.password.copy(
                    first = newValue,
                    second = isError
                )
            )
        )
    }

    private fun showError(errorTextRes: Int) = intent {
        reduce {
            state.copy(
                errorTextRes = errorTextRes,
                inLoading = false
            )
        }
        delay(3000)
        reduce {
            state.copy(errorTextRes = null)
        }
    }

    private fun activateLoading() = reducer {
        state.copy(inLoading = true)
    }

    private fun <T> SupabaseResult<T>.observe() {
        when (this) {
            SupabaseResult.Loading -> activateLoading()
            is SupabaseResult.Error -> showError(errorTextRes = this.errorType.toTextRes())
            is SupabaseResult.Success -> {
                reducer { state.copy(inLoading = false) }
                emitSideEffect(SignInSideEffect.NavigateToHomeScreen)
            }
        }
    }
}