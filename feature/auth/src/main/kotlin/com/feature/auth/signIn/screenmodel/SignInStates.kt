package com.feature.auth.signIn.screenmodel

import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable

@Immutable
data class SignInState(
    val logInData: SignInData = SignInData(),
    @StringRes val errorTextRes: Int? = null,
    val inLoading: Boolean = false
)

@Immutable
data class SignInData(
    val email: Pair<String, Int?> = Pair("", null),
    val password: Pair<String, Int?> = Pair("", null),
)

sealed interface SignInEvent {
    data class OnEmailChange(val newValue: String) : SignInEvent
    data class OnPasswordChange(val newValue: String) : SignInEvent
    data object OnSignUpClick : SignInEvent
    data object OnSignInClick : SignInEvent
    data object OnAnonymousClick : SignInEvent
}

sealed interface SignInSideEffect {
    data object NavigateToSignUpScreen : SignInSideEffect
    data object NavigateToHomeScreen : SignInSideEffect
}
