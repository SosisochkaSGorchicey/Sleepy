package com.core.data.repository

import com.core.domain.repository.DataStoreRepository
import com.core.domain.repository.SupabaseAuthRepository
import io.github.jan.supabase.gotrue.Auth
import io.github.jan.supabase.gotrue.providers.builtin.Email
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

class SupabaseAuthRepositoryImpl(
    private val auth: Auth,
    private val dataStoreRepository: DataStoreRepository
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
            dataStoreRepository.saveToken(newToken = accessToken)
        }
    }

    override suspend fun signAnonim() {
        auth.signInAnonymously(data = createUserData(ANONYMOUS_USER_NAME))
    }

    override suspend fun signUp(
        userName: String,
        email: String,
        password: String
    ) {
        auth.signUpWith(Email) {
            this.email = email
            this.password = password
            this.data = createUserData(userName)
        }
    }

    private fun createUserData(userName: String): JsonObject =
        buildJsonObject {
            put(key = USER_NAME_KEY, value = userName)
        }

    companion object {
        private const val USER_NAME_KEY = "user_name"
        private const val ANONYMOUS_USER_NAME = "Guest"
    }
}