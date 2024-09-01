package com.feature.auth.utils

import com.core.ui.R

private val emailRegex = Regex("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")

fun emailIsValid(email: String): Int? = when {
    (email.isBlank() || email.isEmpty()) -> R.string.error_empty_field
    !email.matches(emailRegex) -> R.string.error_email_invalid_format
    else -> null
}

fun passwordIsValid(password: String): Int? = when {
    (password.isEmpty() || password.isBlank()) -> R.string.error_empty_field
    (password.length < 6) -> R.string.error_password_length
    else -> null
}

fun nameIsValid(name: String): Int? = when {
    (name.isEmpty() || name.isBlank()) -> R.string.error_empty_field
    (name.length > 30) -> R.string.error_name_length
    else -> null
}