package com.core.domain.model.localDB

data class ScheduleItem(
    val id: String = "",
    val createPush: Boolean = true,
    val weekDayId: Int = 1,
    val millisecondOfDay: Int = 0,
    val titleText: String = "",
    val descriptionText: String = ""
) {
    constructor() : this("", true, 1, 0, "", "")
}
