package com.core.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
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

    override fun notificationOnboardingCompleted(): Flow<Boolean> =
        dataStore.data.map { it[NOTIF_ONBOARDING_COMPLETED_KEY] ?: false }

    override suspend fun saveNotificationOnboardingCompleted() {
        withContext(Dispatchers.IO) {
            dataStore.edit {
                it[NOTIF_ONBOARDING_COMPLETED_KEY] = true
            }
        }
    }

    private companion object {
        private val TOKEN_KEY = stringPreferencesKey("jwt_token")
        private val NOTIF_ONBOARDING_COMPLETED_KEY =
            booleanPreferencesKey("notif_onboarding_completed_key")
    }
}