package com.feature.notification.model

enum class WeekItem(
    val id: Int,
    val shortName: String
) {
    Monday(
        id = 0,
        shortName = "M"
    ),
    Tuesday(
        id = 1,
        shortName = "T"
    ),
    Wednesday(
        id = 2,
        shortName = "W"
    ),
    Thursday(
        id = 3,
        shortName = "T"
    ),
    Friday(
        id = 4,
        shortName = "F"
    ),
    Saturday(
        id = 5,
        shortName = "S"
    ),
    Sunday(
        id = 6,
        shortName = "S"
    )
}