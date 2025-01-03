package com.feature.notification.presentation.main.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.core.ui.theme.AppTheme
import com.core.ui.uiElements.mainScreenElements.MoreIcon
import com.feature.notification.presentation.main.screenmodel.NotificationEvent

@Composable
fun DropDownIconButton(
    expanded: Boolean,
    onEvent: (NotificationEvent) -> Unit
) {
    Box {
        MoreIcon(onClick = { onEvent(NotificationEvent.OnDropDownMenuClick) })

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { onEvent(NotificationEvent.OnCloseDropDownMenu) },
            containerColor = AppTheme.colors.baseBlueLight
        ) {
            DropDownItem.entries.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = stringResource(id = item.textRes),
                            style = AppTheme.typography.bodySmall,
                            color = AppTheme.colors.milkyWhite
                        )
                    },
                    onClick = { onEvent(item.notificationEvent) })
            }
        }
    }
}