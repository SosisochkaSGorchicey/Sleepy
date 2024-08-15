package com.core.domain.model

enum class AuthErrorType {
    Timeout,
    HttpRequest,
    ChainValidation,
    UserAlreadyRegistered,
    InvalidLoginCredentials,
    InvalidPasswordFormat,
    InvalidEmailFormat,
    Unauthorized,
    NotFound,
    Unknown
}