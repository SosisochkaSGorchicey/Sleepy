package com.core.domain.model

data class AudioSection(
    val name: String,
    val items: List<AudioDataItem>
)

data class AudioDataItem(
    val imageRes: String
)
