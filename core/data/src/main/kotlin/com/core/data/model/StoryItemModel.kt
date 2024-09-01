package com.core.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoryItemModel(
    val url: String,
    @SerialName("is_image")
    val isImage: Boolean,
    @SerialName("preview_url")
    val previewUrl: String
)
