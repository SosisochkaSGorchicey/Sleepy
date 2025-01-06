package com.core.data.repository

import com.core.data.mapper.toData
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

    override suspend fun saveScheduleItem(scheduleItem: ScheduleItem) {
        scheduleDao.upsertScheduleItem(scheduleItemModel = scheduleItem.toData())
    }

    override suspend fun deleteAll() {
        scheduleDao.deleteAll()
    }

    override suspend fun deleteForWeekDay(weekDayId: Int) {
        scheduleDao.deleteAllWithThisWeekId(weekDayId = weekDayId)
    }

    override suspend fun deleteById(id: Int) {
        scheduleDao.deleteById(id = id)
    }
}