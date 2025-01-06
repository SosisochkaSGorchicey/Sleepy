package com.core.ui.uiElements.mainScreenElements

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.core.ui.theme.AppTheme

@Composable
fun FloatingButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        shape = AppTheme.shapes.rounded,
        containerColor = AppTheme.colors.baseBlueLight,
        contentColor = AppTheme.colors.white
    ) {
        Icon(
            imageVector = Icons.Rounded.Add,
            contentDescription = null
        )
    }
}