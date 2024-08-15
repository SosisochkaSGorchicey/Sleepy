package com.core.data.repository

import com.core.domain.model.SupabaseResult
import com.core.domain.repository.SupabaseAuthRepository
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.coroutines.flow.Flow

class SupabaseAuthRepositoryImpl(
    private val auth: Auth
) : SupabaseAuthRepository {
    override suspend fun signIn(email: String, password: String) {
        auth.signInWith(Email) {
            this.email = email
            this.password = password
        }
    }

    override suspend fun trySaveToken() {
        val accessToken = auth.currentAccessTokenOrNull()
        accessToken?.let {
            //settingsRepository.saveToken(newToken = accessToken) todo
        }
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