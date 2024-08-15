package com.core.data.repository

import com.core.domain.model.SupabaseResult
import com.core.domain.repository.SupabaseAuthRepository
import io.github.jan.supabase.gotrue.Auth
import kotlinx.coroutines.flow.Flow

class SupabaseAuthRepositoryImpl(
    val auth: Auth
) : SupabaseAuthRepository {
    override fun signIn(email: String, password: String): Flow<SupabaseResult<Unit>> {
        TODO("Not yet implemented")
    }

    override fun signAnonim(): Flow<SupabaseResult<Unit>> {
        TODO("Not yet implemented")
    }

    override suspend fun signUp(
        userName: String,
        email: String,
        password: String
    ): Flow<SupabaseResult<Unit>> {
        TODO("Not yet implemented")
    }
}