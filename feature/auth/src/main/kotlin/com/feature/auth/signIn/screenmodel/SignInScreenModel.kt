package com.feature.auth.signIn.screenmodel

import com.core.common.mvi.MviScreenModel
import com.core.common.mvi.blockingReducer
import com.core.common.mvi.emitSideEffect
import com.core.common.mvi.reducer
import com.core.domain.model.supabase.SupabaseResult
import com.core.domain.usecase.SignInUseCase
import com.core.domain.usecase.SignUpAnonymously
import com.feature.auth.utils.emailIsValid
import com.feature.auth.utils.passwordIsValid
import com.core.ui.utils.toTextRes
import kotlinx.coroutines.delay
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class SignInScreenModel(
    private val signInUseCase: SignInUseCase,
    private val signUpAnonymously: SignUpAnonymously
) : MviScreenModel<SignInState, SignInSideEffect, SignInEvent>(
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
        val emailValidationResult = emailIsValid(email = state.logInData.email.first)
        val passwordValidationResult = passwordIsValid(password = state.logInData.password.first)

        if (emailValidationResult == null && passwordValidationResult == null) {
            signInUseCase(
                email = state.logInData.email.first.trim(),
                password = state.logInData.password.first.trim()
            ).collect { supabaseResult ->
                supabaseResult.observe()
            }
        } else {
            showSignInErrors(
                emailValidationResult = emailValidationResult,
                passwordValidationResult = passwordValidationResult
            )
        }
    }

    private fun showSignInErrors(
        emailValidationResult: Int?,
        passwordValidationResult: Int?
    ) = intent {
        emailValidationResult?.let {
            changeEmail(
                newValue = state.logInData.email.first,
                isError = it
            )
        }

        passwordValidationResult?.let {
            changePassword(
                newValue = state.logInData.password.first,
                isError = it
            )
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