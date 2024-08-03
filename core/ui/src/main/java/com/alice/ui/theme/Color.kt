package com.alice.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

private val MilkyWhite = Color(0xFFF7EBE9)
private val BaseBlue = Color(0xFF3873B8)
private val BaseGray = Color(0xFFCACDD3)

private val BlueToGrayGradient = Brush.linearGradient(
    listOf(BaseBlue, BaseGray)
)

@Immutable
data class AppColors(
    val transparent: Color = Color.Transparent,
    val white: Color = Color.White,
    val black: Color = Color.Black,
    val milkyWhite: Color = MilkyWhite,
    val baseBlue: Color = BaseBlue,
    val baseGray: Color = BaseGray,
    val blueToGrayGradient: Brush = BlueToGrayGradient,
)

internal val LocalAppColors = staticCompositionLocalOf { AppColors() }