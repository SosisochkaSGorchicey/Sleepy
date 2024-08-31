package com.core.data.utils

import com.core.domain.model.supabase.AuthErrorType
import com.core.domain.model.supabase.SupabaseResult
import io.github.jan.supabase.exceptions.BadRequestRestException
import io.github.jan.supabase.exceptions.HttpRequestException
import io.github.jan.supabase.exceptions.NotFoundRestException
import io.github.jan.supabase.exceptions.UnauthorizedRestException
import io.github.jan.supabase.gotrue.exception.AuthRestException
import io.ktor.client.plugins.HttpRequestTimeoutException


internal fun Throwable.toSupabaseError(): SupabaseResult.Error = when (this) {
    is HttpRequestException -> {
        if (message?.contains("Chain validation failed") == true) AuthErrorType.ChainValidation
        else AuthErrorType.HttpRequest
    }

    is HttpRequestTimeoutException -> AuthErrorType.Timeout
    is BadRequestRestException ->
        when {
            message?.contains("User already registered") == true ->
                AuthErrorType.UserAlreadyRegistered


            message?.contains("Invalid login credentials") == true ->
                AuthErrorType.InvalidLoginCredentials


            error == "Unable to validate email address: invalid format" ->
                AuthErrorType.InvalidEmailFormat


            error.contains("Password") ->
                AuthErrorType.InvalidPasswordFormat


            else -> AuthErrorType.Unknown
        }

    is AuthRestException -> when {
        message?.contains("User already registered") == true ->
            AuthErrorType.UserAlreadyRegistered

        message?.contains("Unable to validate email address: invalid format") == true ->
            AuthErrorType.InvalidEmailFormat

        message?.contains("User from sub claim in JWT does not exist") == true ->
            AuthErrorType.UserTokenDoesNotExist


        else -> AuthErrorType.Unknown
    }

    is NotFoundRestException -> AuthErrorType.NotFound
    is UnauthorizedRestException -> AuthErrorType.Unauthorized
    else -> AuthErrorType.Unknown
}.run { SupabaseResult.Error(this) }