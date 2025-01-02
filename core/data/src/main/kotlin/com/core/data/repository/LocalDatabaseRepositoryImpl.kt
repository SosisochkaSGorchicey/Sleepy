package com.core.data.repository

import com.core.data.mapper.toDomain
import com.core.database.dao.ScheduleDao
import com.core.domain.model.localDB.ScheduleItem
import com.core.domain.repository.LocalDatabaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalDatabaseRepositoryImpl(
    private val scheduleDao: ScheduleDao
) : LocalDatabaseRepository {
    override fun itemsByWeekDayId(weekDayId: Int): Flow<List<ScheduleItem>> =
        scheduleDao.itemsByWeekDayId(weekDayId = weekDayId)
            .map { it.toDomain() }
}