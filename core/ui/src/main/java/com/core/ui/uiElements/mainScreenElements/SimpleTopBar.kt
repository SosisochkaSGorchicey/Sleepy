package com.core.ui.uiElements.mainScreenElements

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.core.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTopBar(
    navigationIcon: @Composable () -> Unit = {},
    titleText: String = "",
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = titleText,
                style = AppTheme.typography.bodyLarge
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = AppTheme.colors.transparent,
            titleContentColor = AppTheme.colors.milkyWhite
        ),
        navigationIcon = navigationIcon
    )
}