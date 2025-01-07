package com.core.ui.utils

import kotlinx.datetime.LocalTime
import kotlinx.datetime.format
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern

fun Int.millisecondsToTime(): String {
    val localTime = LocalTime.fromMillisecondOfDay(this)
    val formatPattern = "HH:mm"

    @OptIn(FormatStringsInDatetimeFormats::class)
    val dateTimeFormat = LocalTime.Format {
        byUnicodePattern(formatPattern)
    }
    return localTime.format(dateTimeFormat)
}

fun Int.millisecondsToLocalTime(): LocalTime =
    LocalTime.fromMillisecondOfDay(this)