package com.core.ui.uiElements

import Error
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.core.ui.icons.SleepyIcons
import com.core.ui.theme.AppTheme

@Composable
fun ErrorDisplay() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = SleepyIcons.Error,
            contentDescription = null,
            tint = AppTheme.colors.milkyWhite
        )
    }
}