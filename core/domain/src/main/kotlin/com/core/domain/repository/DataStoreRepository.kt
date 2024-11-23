package com.core.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    fun getToken(): Flow<String>
    suspend fun saveToken(newToken: String)
    suspend fun deleteToken()

    fun notificationOnboardingCompleted(): Flow<Boolean>
    suspend fun saveNotificationOnboardingCompleted()
}