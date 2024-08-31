package com.core.domain.model.supabase

enum class AuthErrorType {
    Timeout,
    HttpRequest,
    ChainValidation,
    UserAlreadyRegistered,
    InvalidLoginCredentials,
    InvalidPasswordFormat,
    InvalidEmailFormat,
    UserTokenDoesNotExist,
    Unauthorized,
    NotFound,
    Unknown
}