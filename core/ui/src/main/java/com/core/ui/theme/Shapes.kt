package com.core.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

@Immutable
class AppShapes(
    val rounded: RoundedCornerShape = RoundedCornerShape(50),
    val topForm: RoundedCornerShape = RoundedCornerShape(
        topStartPercent = 10,
        topEndPercent = 60
    ),
    val smallCornersDp: RoundedCornerShape = RoundedCornerShape(20.dp),
    val mediumCornersDp: RoundedCornerShape = RoundedCornerShape(40.dp),
    val mediumCornersPercent: RoundedCornerShape = RoundedCornerShape(25)
)

internal val LocalAppShapes = staticCompositionLocalOf { AppShapes() }