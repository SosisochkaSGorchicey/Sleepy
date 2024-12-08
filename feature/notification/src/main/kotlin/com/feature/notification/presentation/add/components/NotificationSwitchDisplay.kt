package com.feature.notification.presentation.add.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.core.ui.R
import com.core.ui.theme.AppTheme

@Composable
fun NotificationSwitchDisplay(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedBorderColor = AppTheme.colors.baseBlue,
                checkedThumbColor = AppTheme.colors.milkyWhite,
                checkedTrackColor = AppTheme.colors.baseBlue,
                uncheckedBorderColor = AppTheme.colors.milkyWhite,
                uncheckedThumbColor = AppTheme.colors.baseBlueLight,
                uncheckedTrackColor = AppTheme.colors.milkyWhite
            )
        )

        Text(
            text = stringResource(R.string.notification_state_description),
            style = AppTheme.typography.bodySmall
        )
    }
}