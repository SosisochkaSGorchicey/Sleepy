package com.core.domain.model.supabase

import com.core.domain.model.supabase.auth.AuthErrorType

sealed interface SupabaseResult<out T> {
    data object Loading : SupabaseResult<Nothing>

    data class Success<out T>(val data: T) : SupabaseResult<T>

    data class Error(val errorType: AuthErrorType) : SupabaseResult<Nothing>
}