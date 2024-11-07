package com.core.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

private val MilkyWhite = Color(0xFFF7EBE9)
private val BaseRed = Color(0xFFB83847)
private val LightRed = Color(0xFFDD5F6A)
private val BaseBlue = Color(0xFF3873B8)
private val BaseBlueLight = Color(0xFF719CCE)
private val BaseBlueLighter = Color(0xFF9FBFE4)
private val BaseGray = Color(0xFFCACDD3)
private val DarkerGray = Color(0xFF798191)
private val BasePeachy = Color(0xFFEECEC9)
private val LightPeachy = Color(0xFFF1DEDB)
private val Black = Color(0xFF11141A)

private val BlueToGrayGradientLinear = Brush.linearGradient(listOf(BaseBlue, BaseGray))
private val BlueToBlueGradientLightVertical =
    Brush.verticalGradient(listOf(BaseBlueLighter, BaseBlueLight))


@Immutable
data class AppColors(
    val transparent: Color = Color.Transparent,
    val white: Color = Color.White,
    val black: Color = Black,
    val milkyWhite: Color = MilkyWhite,
    val baseRed: Color = BaseRed,
    val baseBlue: Color = BaseBlue,
    val baseBlueLight: Color = BaseBlueLight,
    val baseGray: Color = BaseGray,
    val darkerGray: Color = DarkerGray,
    val basePeachy: Color = BasePeachy,
    val lightPeachy: Color = LightPeachy,
    val lightRed: Color = LightRed,

    val blueToGrayGradientLinear: Brush = BlueToGrayGradientLinear,
    val blueToBlueGradientLightVertical: Brush = BlueToBlueGradientLightVertical,
)

internal val LocalAppColors = staticCompositionLocalOf { AppColors() }