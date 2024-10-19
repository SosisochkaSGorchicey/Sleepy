package com.core.ui.modifiers

import androidx.compose.foundation.border
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.core.ui.theme.AppTheme

val Modifier.baseRoundedBorder: @Composable (Color) -> Modifier
    get() = @Composable { color: Color ->
        this.then(
            Modifier.border(
                width = 3.dp,
                color = color,
                shape = AppTheme.shapes.rounded
            )
        )
    }