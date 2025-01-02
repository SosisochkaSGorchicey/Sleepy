package com.core.domain.model.localDB

data class ScheduleItem(
    val id: Int? = null,
    val createPush: Boolean,
    val weekDayId: Int,
    val millisecondOfDay: Int,
    val titleText: String,
    val descriptionText: String
)
