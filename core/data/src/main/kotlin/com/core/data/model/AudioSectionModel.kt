package com.core.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AudioSectionModel(
    val id: Int,
    val name: String,
)

@Serializable
data class AudioDataItemModel(
    @SerialName("section_id")
    val sectionId: Int,
    @SerialName("image_url")
    val imageUrl: String,
)