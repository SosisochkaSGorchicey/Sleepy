package com.core.domain.repository

import com.core.domain.model.SupabaseResult
import kotlinx.coroutines.flow.Flow

interface SupabaseAuthRepository {
    suspend fun signIn(
        email: String,
        password: String
    )

    suspend fun trySaveToken()

    fun signAnonim(): Flow<SupabaseResult<Unit>>

    suspend fun signUp(
        userName: String,
        email: String,
        password: String
    ): Flow<SupabaseResult<Unit>>
}