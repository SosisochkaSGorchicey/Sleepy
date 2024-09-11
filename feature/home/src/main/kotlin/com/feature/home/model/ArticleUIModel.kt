package com.feature.home.model

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

data class ArticleUIModel(
    val id: Int,
    val title: String,
    val description: String?,
    val backgroundImageUrl: String?,
    val backgroundBrush: Brush,
    val titleColor: Color,
    val descriptionColor: Color,
    val isFullSize: Boolean
)
