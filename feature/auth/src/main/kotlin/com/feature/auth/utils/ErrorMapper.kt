package com.feature.auth.utils

import com.core.domain.model.supabase.AuthErrorType
import com.core.ui.R

fun AuthErrorType.toTextRes(): Int = when (this) {
    AuthErrorType.Timeout -> R.string.error_timeout
    AuthErrorType.HttpRequest -> R.string.error_network_connection
    AuthErrorType.ChainValidation -> R.string.error_chain_validation
    AuthErrorType.UserAlreadyRegistered -> R.string.error_already_registered
    AuthErrorType.InvalidLoginCredentials -> R.string.error_invalid_login
    AuthErrorType.InvalidPasswordFormat -> R.string.error_password_invalid_format
    AuthErrorType.InvalidEmailFormat -> R.string.error_email_invalid_format
    AuthErrorType.Unauthorized -> R.string.error_unauthorized
    AuthErrorType.NotFound -> R.string.error_unknown
    AuthErrorType.Unknown -> R.string.error_unknown
    AuthErrorType.UserTokenDoesNotExist -> R.string.error
}