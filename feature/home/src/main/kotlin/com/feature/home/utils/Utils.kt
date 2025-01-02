package com.feature.home.utils

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.core.domain.model.supabase.auth.AuthErrorType
import com.core.ui.R


fun AuthErrorType.toTextRes(): Int = when (this) {
    AuthErrorType.Timeout -> R.string.error_timeout
    AuthErrorType.HttpRequest -> R.string.error_network_connection
    AuthErrorType.ChainValidation -> R.string.error_chain_validation
    else -> R.string.error_unknown
}

fun Int.toPadding(lastIndex: Int): Modifier =
    when (this) {
        0 -> Modifier.padding(start = 10.dp)
        lastIndex -> Modifier.padding(end = 10.dp)
        else -> Modifier
    }