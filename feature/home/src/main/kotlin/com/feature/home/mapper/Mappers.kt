package com.feature.home.mapper

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.core.domain.model.ArticleItem
import com.feature.home.model.ArticleUIModel

fun ArticleItem.toPresentation(): ArticleUIModel =
    ArticleUIModel(
        id = this.id,
        title = this.title,
        description = this.description,
        backgroundImageUrl = this.backgroundImageUrl,
        backgroundBrush =,
        titleColor =,
        descriptionColor =,
        isFullSize = this.isFullSize
    )


fun Int.toBrushToColor(): Pair<Brush, Color> {

}