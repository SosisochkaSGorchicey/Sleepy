package com.feature.home.mapper

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.core.domain.model.supabase.db.ArticleItem
import com.feature.home.model.ArticleUIModel

private val White = Color(0xFFFFFFFF)
private val MilkyWhite = Color(0xFFF7EBE9)
private val BaseBlue = Color(0xFF3873B8)
private val BaseBlueDarker = Color(0xFF195192)
private val BaseBlueLight = Color(0xFF719CCE)
private val BaseGray = Color(0xFFCACDD3)
private val BasePeachy = Color(0xFFEECEC9)

private val BlueToGrayGradient = Brush.linearGradient(listOf(BaseBlue, BaseGray))
private val MilkyWhiteToBlueGradient = Brush.linearGradient(listOf(MilkyWhite, BaseBlue))
private val BlueToBaseBlueLight = Brush.linearGradient(listOf(BaseBlue, BaseBlueLight))
private val MilkyWhiteToBaseBlueLight = Brush.linearGradient(listOf(MilkyWhite, BaseBlueLight))
private val BasePeachyToBaseBlueLight = Brush.linearGradient(listOf(BasePeachy, BaseBlueLight))

private val darkText = Pair(BaseBlue, BaseBlueDarker)
private val lightText = Pair(MilkyWhite, White)

fun ArticleItem.toPresentation(): ArticleUIModel {
    val currentBrushToColor = this.id.toBrushToColor()
    val textColor = this.textIsLight.toTextColors() ?: currentBrushToColor.second

    return ArticleUIModel(
        id = this.id,
        title = this.title,
        description = this.description,
        backgroundImageUrl = this.backgroundImageUrl,
        backgroundBrush = currentBrushToColor.first,
        titleColor = textColor.first,
        descriptionColor = textColor.second,
        isFullSize = this.isFullSize,
    )
}

fun Boolean?.toTextColors(): Pair<Color, Color>? = when (this) {
    null -> null
    true -> lightText
    false -> darkText
}


fun Int.toBrushToColor(): Pair<Brush, Pair<Color, Color>> = when {
    this % 5 == 0 -> Pair(MilkyWhiteToBaseBlueLight, lightText)
    this % 4 == 0 -> Pair(BlueToBaseBlueLight, lightText)
    this % 3 == 0 -> Pair(MilkyWhiteToBlueGradient, lightText)
    this % 2 == 0 -> Pair(BlueToGrayGradient, lightText)
    else -> Pair(BasePeachyToBaseBlueLight, darkText)
}