package com.core.data.repository

import com.core.domain.repository.DataStoreRepository
import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.coroutines.getStringFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

@OptIn(ExperimentalSettingsApi::class)
class DataStoreRepositoryImpl(
    private val settings: ObservableSettings
) : DataStoreRepository {
    override fun getToken(): Flow<String> =
        settings.getStringFlow(key = TOKEN_KEY, defaultValue = "").flowOn(Dispatchers.IO)

    override suspend fun saveToken(newToken: String) = withContext(Dispatchers.IO) {
        settings.putString(key = TOKEN_KEY, value = newToken)
    }

    override suspend fun deleteToken() = withContext(Dispatchers.IO) {
        settings.remove(key = TOKEN_KEY)
    }

    private companion object {
        const val TOKEN_KEY = "jwt_token"
    }
}