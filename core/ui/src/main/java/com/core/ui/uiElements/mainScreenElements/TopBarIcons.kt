package com.core.ui.uiElements.mainScreenElements

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.core.ui.theme.AppTheme

@Composable
fun ArrowBackIcon(onClick: () -> Unit) {
    IconButtonBase(
        onClick = onClick,
        imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowLeft
    )
}

@Composable
fun SimpleBackIcon(onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = AppTheme.colors.transparent,
            contentColor = AppTheme.colors.milkyWhite
        )
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
            contentDescription = null
        )
    }
}

@Composable
fun SettingsIcon(onClick: () -> Unit) {
    IconButtonBase(
        onClick = onClick,
        imageVector = Icons.Rounded.Settings
    )
}

@Composable
fun AccountIcon(onClick: () -> Unit) {
    IconButtonBase(
        onClick = onClick,
        imageVector = Icons.Rounded.Face
    )
}

@Composable
private fun IconButtonBase(
    onClick: () -> Unit,
    imageVector: ImageVector
) {
    IconButton(
        onClick = onClick,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = AppTheme.colors.lightPeachy,
            contentColor = AppTheme.colors.baseBlue
        )
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null
        )
    }
}
