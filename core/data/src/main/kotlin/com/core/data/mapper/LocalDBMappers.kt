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

fun ScheduleItem.toData(): ScheduleItemModel =
    ScheduleItemModel(
        createPush = this.createPush,
        weekDayId = this.weekDayId,
        millisecondOfDay = this.millisecondOfDay,
        titleText = this.titleText,
        descriptionText = this.descriptionText
    )