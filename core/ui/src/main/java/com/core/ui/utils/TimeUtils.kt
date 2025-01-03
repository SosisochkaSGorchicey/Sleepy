package com.core.ui.utils

import kotlinx.datetime.LocalTime

fun Int.millisecondsToTime(): String {
    val localTime = LocalTime.fromMillisecondOfDay(this)
    return "${localTime.hour}:${localTime.minute}"
}