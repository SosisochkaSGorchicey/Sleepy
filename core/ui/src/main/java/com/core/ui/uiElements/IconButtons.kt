package com.core.ui.uiElements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.core.ui.theme.AppTheme

@Composable
fun ArrowRightIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Icon(
        modifier = modifier
            .size(28.dp)
            .clip(AppTheme.shapes.rounded)
            .clickable(onClick = onClick)
            .padding(4.dp),
        imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
        contentDescription = null,
        tint = AppTheme.colors.white
    )
}