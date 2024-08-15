package com.feature.auth.signIn.screenmodel

import com.core.common.mvi.MviScreenMode
import com.core.common.mvi.blockingReducer
import com.core.common.mvi.emitSideEffect

class SignInScreenModel : MviScreenMode<SignInState, SignInSideEffect, SignInEvent>(
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

    private fun signInAnonymously() {
        //todo
    }

    private fun signIn() {
        //todo
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
}