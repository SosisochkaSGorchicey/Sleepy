package com.core.domain.repository

import com.core.domain.model.localDB.ScheduleItem

interface FirestoreRepository {
    suspend fun saveSchedule(userId: String, scheduleItem: ScheduleItem)
}