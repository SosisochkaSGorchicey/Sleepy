package com.core.ui.uiElements.mainScreenElements

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.core.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    onNavigateBackClick: () -> Unit
) {
    TopAppBar(
        title = { },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = AppTheme.colors.transparent,
            navigationIconContentColor = AppTheme.colors.baseBlue
        ),
        navigationIcon = {
            IconButton(
                onClick = onNavigateBackClick,
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = AppTheme.colors.lightPeachy
                )
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
                    contentDescription = null
                )
            }
        }
    )
}