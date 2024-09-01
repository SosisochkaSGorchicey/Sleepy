package com.core.domain.model.supabase

sealed class LoggedInState {
    data object Loading : LoggedInState()
    data class Error(val supabaseResult: SupabaseResult.Error) : LoggedInState()
    data object LoggedIn : LoggedInState()
    data object NotLoggedIn : LoggedInState()
}