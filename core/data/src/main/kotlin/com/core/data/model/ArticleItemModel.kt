package com.core.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleItemModel(
    val id: Int,
    val title: String,
    val description: String?,
    @SerialName("background_image")
    val backgroundImageUrl: String?,
    @SerialName("is_full_size")
    val isFullSize: Boolean,
    @SerialName("text_is_light")
    val textIsLight: Boolean?,
)