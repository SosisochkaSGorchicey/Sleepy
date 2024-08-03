package com.alice.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Immutable
class AppTypography(
    val headlineLarge: TextStyle = TextStyle(
        fontSize = 72.sp,
        textAlign = TextAlign.Center,
        fontFamily = mainFont
    )
)

internal val LocalAppTypography = staticCompositionLocalOf { AppTypography() }