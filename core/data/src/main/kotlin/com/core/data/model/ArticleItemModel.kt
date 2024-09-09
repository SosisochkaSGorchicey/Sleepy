package com.core.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleItemModel(
    val id: Int,
    val title: String,
    val description: String? = null,
    @SerialName("background_image")
    val backgroundImageUrl: String? = null,
    @SerialName("is_full_size")
    val isFullSize: Boolean = false
)