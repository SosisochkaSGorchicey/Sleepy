package com.feature.auth.signUp.screenmodel

import com.core.common.mvi.MviScreenMode
import com.core.common.mvi.blockingReducer
import com.core.common.mvi.emitSideEffect

class SignUpScreenModel : MviScreenMode<SignUpState, SignUpSideEffect, SignUpEvent>(
    initialState = SignUpState()
) {
    override fun onEvent(event: SignUpEvent) {
        when (event) {
            SignUpEvent.OnBackClick -> emitSideEffect(SignUpSideEffect.NavigateBack)
            is SignUpEvent.OnEmailChange -> changeEmail(newValue = event.newValue)
            is SignUpEvent.OnNameChange -> changeName(newValue = event.newValue)
            is SignUpEvent.OnPasswordChange -> changePassword(newValue = event.newValue)
            SignUpEvent.OnSignUpClick -> signUp()
        }
    }

    private fun signUp() {
        //todo
    }

    private fun changeName(
        newValue: String,
        isError: Int? = null
    ) = blockingReducer {
        state.copy(
            signUpData = state.signUpData.copy(
                name = state.signUpData.name.copy(
                    first = newValue,
                    second = isError
                )
            )
        )
    }

    private fun changeEmail(
        newValue: String,
        isError: Int? = null
    ) = blockingReducer {
        state.copy(
            signUpData = state.signUpData.copy(
                email = state.signUpData.email.copy(
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
            signUpData = state.signUpData.copy(
                password = state.signUpData.password.copy(
                    first = newValue,
                    second = isError
                )
            )
        )
    }
}