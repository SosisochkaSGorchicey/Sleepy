package com.core.domain.model

data class AudioSection(
    val name: String,
    val items: List<AudioDataItem>
)

data class AudioDataItem(
    val imageRes: String = "",
    val audioUrl: String = "",
    val minutesDuration: Int = 0,
    val isFavourite: Boolean = false,
    val name: String = "",
    val tag: String = "",
)
