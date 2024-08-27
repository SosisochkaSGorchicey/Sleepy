package com.feature.auth.signUp.screenmodel

import com.core.common.mvi.MviScreenModel
import com.core.common.mvi.blockingReducer
import com.core.common.mvi.emitSideEffect
import com.core.common.mvi.reducer
import com.core.domain.model.supabaseAuth.SupabaseResult
import com.core.domain.usecase.SignUpUseCase
import com.feature.auth.utils.emailIsValid
import com.feature.auth.utils.nameIsValid
import com.feature.auth.utils.passwordIsValid
import com.feature.auth.utils.toTextRes
import kotlinx.coroutines.delay
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class SignUpScreenModel(
    private val signUpUseCase: SignUpUseCase
) : MviScreenModel<SignUpState, SignUpSideEffect, SignUpEvent>(
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

    private fun signUp() = intent {
        val nameValidationResult = nameIsValid(name = state.signUpData.name.first)
        val emailValidationResult = emailIsValid(email = state.signUpData.email.first)
        val passwordValidationResult = passwordIsValid(password = state.signUpData.password.first)

        if (nameValidationResult == null && emailValidationResult == null && passwordValidationResult == null) {
            signUpUseCase(
                userName = state.signUpData.name.first.trim(),
                email = state.signUpData.email.first.trim(),
                password = state.signUpData.password.first.trim()
            ).collect { supabaseResult ->
                supabaseResult.observe()
            }
        } else {
            showSignUpErrors(
                nameValidationResult = nameValidationResult,
                emailValidationResult = emailValidationResult,
                passwordValidationResult = passwordValidationResult
            )
        }
    }

    private fun showSignUpErrors(
        nameValidationResult: Int?,
        emailValidationResult: Int?,
        passwordValidationResult: Int?
    ) = intent {
        nameValidationResult?.let {
            changeName(
                newValue = state.signUpData.name.first,
                isError = it
            )
        }

        emailValidationResult?.let {
            changeEmail(
                newValue = state.signUpData.email.first,
                isError = it
            )
        }

        passwordValidationResult?.let {
            changePassword(
                newValue = state.signUpData.password.first,
                isError = it
            )
        }
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
                emitSideEffect(SignUpSideEffect.NavigateToHomeScreen)
            }
        }
    }
}