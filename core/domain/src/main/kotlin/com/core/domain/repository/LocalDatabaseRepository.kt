package com.core.domain.repository

import com.core.domain.model.localDB.ScheduleItem
import kotlinx.coroutines.flow.Flow

interface LocalDatabaseRepository {
    fun itemsByWeekDayId(weekDayId: Int): Flow<List<ScheduleItem>>

    suspend fun saveScheduleItem(scheduleItem: ScheduleItem)
}