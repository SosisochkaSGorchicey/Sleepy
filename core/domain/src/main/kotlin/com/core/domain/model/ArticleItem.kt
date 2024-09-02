package com.core.domain.model

data class ArticleItem(
    val id: Int,
    val title: String,
    val description: String? = null,
    val backgroundImageUrl: String,
    val isFullSize: Boolean = false
)