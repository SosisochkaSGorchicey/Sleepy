package com.core.domain.model.supabaseAuth

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