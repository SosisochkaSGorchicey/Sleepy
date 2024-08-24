package com.core.domain.model.supabaseAuth

sealed interface SupabaseResult<out T> {
    data object Loading : SupabaseResult<Unit>

    data class Success<out T>(val data: T) : SupabaseResult<T>

    data class Error(val errorType: AuthErrorType) : SupabaseResult<Nothing>
}