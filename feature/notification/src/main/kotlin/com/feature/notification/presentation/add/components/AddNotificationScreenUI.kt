package com.feature.notification.presentation.add.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.core.ui.modifiers.hideKeyboardByTaping
import com.core.ui.theme.AppTheme
import com.core.ui.uiElements.ErrorSnackbar
import com.core.ui.uiElements.mainScreenElements.SimpleBackIcon
import com.core.ui.uiElements.mainScreenElements.SimpleTopBar
import com.feature.notification.presentation.add.screenmodel.AddNotificationEvent
import com.feature.notification.presentation.add.screenmodel.AddNotificationState

@Composable
fun AddNotificationScreenUI(
    state: AddNotificationState,
    onEvent: (AddNotificationEvent) -> Unit
) {
    Scaffold(
        topBar = {
            SimpleTopBar(
                navigationIcon = {
                    SimpleBackIcon(
                        contentColor = AppTheme.colors.baseBlue,
                        onClick = { onEvent(AddNotificationEvent.OnBackButtonClick) }
                    )
                }
            )
        },
        containerColor = AppTheme.colors.baseGray,
        contentColor = AppTheme.colors.baseBlue
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .hideKeyboardByTaping()
        ) {
            BackgroundImage()

            MainLayout(
                padding = padding,
                state = state,
                onEvent = onEvent
            )
        }

        state.errorTextRes?.let {
            ErrorSnackbar(
                modifier = Modifier.padding(padding),
                errorTextRes = it
            )
        }
    }
}