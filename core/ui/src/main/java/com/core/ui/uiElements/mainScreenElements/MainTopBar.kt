package com.core.ui.uiElements.mainScreenElements

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import com.core.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    titleText: String = ""
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = titleText,
                style = AppTheme.typography.bodyMedium.copy(textAlign = TextAlign.Center)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = AppTheme.colors.transparent,
            navigationIconContentColor = AppTheme.colors.baseBlue,
            titleContentColor = AppTheme.colors.milkyWhite
        ),
        navigationIcon = navigationIcon,
        actions = actions
    )
}