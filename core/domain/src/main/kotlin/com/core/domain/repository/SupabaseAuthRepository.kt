package com.core.domain.repository

import com.core.domain.model.supabase.LoggedInState
import io.github.jan.supabase.gotrue.SessionStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface SupabaseAuthRepository {
    suspend fun signIn(
        email: String,
        password: String
    )

    suspend fun trySaveToken()

    suspend fun signAnonim()

    suspend fun signUp(
        userName: String,
        email: String,
        password: String
    )

    fun isUserLoggedIn(): Flow<LoggedInState>

    suspend fun refresh()

    suspend fun getSessionStatus(): StateFlow<SessionStatus>
}