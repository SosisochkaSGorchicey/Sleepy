package com.feature.auth.signUp.screenmodel

import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable

@Immutable
data class SignUpState(
    val signUpData: SignUpData = SignUpData(),
    @StringRes val errorTextRes: Int? = null,
    val inLoading: Boolean = false
)

@Immutable
data class SignUpData(
    val name: Pair<String, Int?> = Pair("", null),
    val email: Pair<String, Int?> = Pair("", null),
    val password: Pair<String, Int?> = Pair("", null),
)

sealed interface SignUpEvent {
    data class OnNameChange(val newValue: String) : SignUpEvent
    data class OnEmailChange(val newValue: String) : SignUpEvent
    data class OnPasswordChange(val newValue: String) : SignUpEvent
    data object OnSignUpClick : SignUpEvent
    data object OnBackClick : SignUpEvent
}

sealed interface SignUpSideEffect {
    data object NavigateBack : SignUpSideEffect
    data object NavigateToHomeScreen : SignUpSideEffect
}