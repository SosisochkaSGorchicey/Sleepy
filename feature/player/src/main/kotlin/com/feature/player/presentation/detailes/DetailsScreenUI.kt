package com.feature.player.presentation.detailes

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.core.ui.theme.AppTheme
import com.core.ui.uiElements.mainScreenElements.SimpleBackIcon
import com.core.ui.uiElements.mainScreenElements.SimpleTopBar

@Composable
fun DetailsScreenUI() {
    Scaffold(
        containerColor = AppTheme.colors.baseBlueLight,
        contentColor = AppTheme.colors.black,
        topBar = {
            SimpleTopBar(
                navigationIcon = {
                    SimpleBackIcon(
                        onClick = {}
                    )
                },
                titleText = "Name of item"
            )
        }
    ) {

    }

}