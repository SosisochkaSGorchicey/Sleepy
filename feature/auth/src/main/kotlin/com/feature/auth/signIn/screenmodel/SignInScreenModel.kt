package com.feature.auth.signIn.screenmodel

import com.alice.common.mvi.MviScreenMode

class SignInScreenModel : MviScreenMode<SignInState, SignInSideEffect, SignInEvent>(
    initialState = SignInState()
) {
    override fun onEvent(event: SignInEvent) {
        when (event) {
            SignInEvent.OnAnonymousClick -> TODO()
            is SignInEvent.OnEmailChange -> TODO()
            is SignInEvent.OnPasswordChange -> TODO()
            SignInEvent.OnSignInClick -> TODO()
            SignInEvent.OnSignUpClick -> TODO()
        }
    }
}