package com.alice.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

@Immutable
class AppShapes(
    val mediumCorners: RoundedCornerShape = RoundedCornerShape(20),
    val mediumCornersDP: RoundedCornerShape = RoundedCornerShape(30.dp),
    val smallCorners: RoundedCornerShape = RoundedCornerShape(10),
    val largeBottomCorners: RoundedCornerShape = RoundedCornerShape(
        bottomEndPercent = 30,
        bottomStartPercent = 30
    ),
    val mediumTopCorners: RoundedCornerShape = RoundedCornerShape(
        topStartPercent = 20,
        topEndPercent = 20
    ),
    val rounded: RoundedCornerShape = RoundedCornerShape(50)
)

internal val LocalAppShapes = staticCompositionLocalOf { AppShapes() }