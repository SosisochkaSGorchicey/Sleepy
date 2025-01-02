package com.core.domain.model.supabase.auth

import com.core.domain.model.supabase.SupabaseResult

sealed class LoggedInState {
    data object Loading : LoggedInState()
    data class Error(val supabaseResult: SupabaseResult.Error) : LoggedInState()
    data object LoggedIn : LoggedInState()
    data object NotLoggedIn : LoggedInState()
}