package com.core.domain.model.supabase.auth

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