package com.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schedule_table")
data class ScheduleItemModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val createPush: Boolean,
    val weekDayId: Int,
    val millisecondOfDay: Int,
    val titleText: String,
    val descriptionText: String
)
