package com.core.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

private val MilkyWhite = Color(0xFFF7EBE9)
private val BaseRed = Color(0xFFB83847)
private val BaseBlue = Color(0xFF3873B8)
private val BaseBlueLight = Color(0xFF719CCE)
private val BaseGray = Color(0xFFCACDD3)
private val DarkerGray = Color(0xFF798191)
private val BasePeachy = Color(0xFFEECEC9)
private val LightPeachy = Color(0xFFF1DEDB)

private val BlueToGrayGradient = Brush.linearGradient(
    listOf(BaseBlue, BaseGray)
)

@Immutable
data class AppColors(
    val transparent: Color = Color.Transparent,
    val white: Color = Color.White,
    val black: Color = Color.Black,
    val milkyWhite: Color = MilkyWhite,
    val baseRed: Color = BaseRed,
    val baseBlue: Color = BaseBlue,
    val baseBlueLight: Color = BaseBlueLight,
    val baseGray: Color = BaseGray,
    val darkerGray: Color = DarkerGray,
    val basePeachy: Color = BasePeachy,
    val lightPeachy: Color = LightPeachy,
    val blueToGrayGradient: Brush = BlueToGrayGradient,
)

internal val LocalAppColors = staticCompositionLocalOf { AppColors() }