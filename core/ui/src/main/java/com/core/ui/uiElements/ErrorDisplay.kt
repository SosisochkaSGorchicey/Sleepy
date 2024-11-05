package com.core.ui.uiElements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.core.ui.icons.MyIconPack
import com.core.ui.icons.myiconpack.Error
import com.core.ui.theme.AppTheme

@Composable
fun ErrorDisplay(
    tintColor: Color = AppTheme.colors.milkyWhite
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = MyIconPack.Error,
            contentDescription = null,
            tint = tintColor
        )
    }
}