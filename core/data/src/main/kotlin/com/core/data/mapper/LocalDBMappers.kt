package com.core.data.mapper

import com.core.database.model.ScheduleItemModel
import com.core.domain.model.localDB.ScheduleItem

fun List<ScheduleItemModel>.toDomain(): List<ScheduleItem> =
    this.map { item ->
        ScheduleItem(
            id = item.id,
            createPush = item.createPush,
            weekDayId = item.weekDayId,
            millisecondOfDay = item.millisecondOfDay,
            titleText = item.titleText,
            descriptionText = item.descriptionText
        )
    }