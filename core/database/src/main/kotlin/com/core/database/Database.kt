package com.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.core.database.dao.ScheduleDao
import com.core.database.model.ScheduleItemModel

@Database(
    version = 1,
    exportSchema = false,
    entities = [ScheduleItemModel::class]
)
abstract class Database : RoomDatabase() {

    abstract val scheduleDao: ScheduleDao

    companion object {
        const val DATABASE_NAME = "sleepy.db"
    }
}
