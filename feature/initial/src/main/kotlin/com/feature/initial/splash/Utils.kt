package com.feature.initial.splash

import com.core.domain.model.supabase.AuthErrorType
import com.core.ui.R

fun AuthErrorType.toTextRes(): Int = when (this) {
    AuthErrorType.Timeout -> R.string.error_timeout
    AuthErrorType.HttpRequest -> R.string.error_network_connection
    AuthErrorType.ChainValidation -> R.string.error_chain_validation
    else -> R.string.error_unknown
}