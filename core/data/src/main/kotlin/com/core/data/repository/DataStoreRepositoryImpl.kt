package com.core.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.core.domain.repository.DataStoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class DataStoreRepositoryImpl(
    private val dataStore: DataStore<Preferences>
) : DataStoreRepository {
    override fun getToken(): Flow<String> =
        dataStore.data.map { it[TOKEN_KEY] ?: "" }

    override suspend fun saveToken(newToken: String) {
        withContext(Dispatchers.IO) {
            dataStore.edit {
                it[TOKEN_KEY] = newToken
            }
        }
    }

    override suspend fun deleteToken() {
        withContext(Dispatchers.IO) {
            dataStore.edit {
                it[TOKEN_KEY] = ""
            }
        }
    }

    private companion object {
        private val TOKEN_KEY = stringPreferencesKey("jwt_token")
    }
}