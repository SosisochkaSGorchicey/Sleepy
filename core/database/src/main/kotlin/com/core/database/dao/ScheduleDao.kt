package com.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.core.database.model.ScheduleItemModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao {
    @Query(
        "SELECT * FROM schedule_table " +
                "WHERE weekDayId = :weekDayId " +
                "ORDER BY millisecondOfDay"
    )
    fun itemsByWeekDayId(weekDayId: Int): Flow<List<ScheduleItemModel>>

    @Upsert
    fun upsertScheduleItem(scheduleItemModel: ScheduleItemModel)

    @Query("DELETE FROM schedule_table")
    fun deleteAll()

    @Query(
        "DELETE FROM schedule_table " +
                "WHERE weekDayId = :weekDayId"
    )
    fun deleteAllWithThisWeekId(weekDayId: Int)

    @Query(
        "DELETE FROM schedule_table " +
                "WHERE id = :id"
    )
    fun deleteById(id: Int)
}
