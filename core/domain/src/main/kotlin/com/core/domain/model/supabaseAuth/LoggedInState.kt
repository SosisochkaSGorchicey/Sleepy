package com.core.domain.model.supabaseAuth

sealed class LoggedInState {
    data object Loading : LoggedInState()
    data class Error(val supabaseResult: SupabaseResult.Error) : LoggedInState()
    data object LoggedIn : LoggedInState()
    data object NotLoggedIn : LoggedInState()
}