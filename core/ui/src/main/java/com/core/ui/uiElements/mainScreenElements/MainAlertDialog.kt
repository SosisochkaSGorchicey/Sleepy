package com.core.ui.uiElements.mainScreenElements

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.core.ui.R
import com.core.ui.theme.AppTheme

@Composable
fun MainAlertDialog(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String = stringResource(R.string.warning_default_title),
    dialogText: String,
    icon: ImageVector = Icons.Outlined.Info
) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(
                text = dialogTitle,
                style = AppTheme.typography.bodyMedium.copy(
                    textAlign = TextAlign.Center
                )
            )
        },
        text = {
            Text(
                text = dialogText,
                style = AppTheme.typography.bodySmall.copy(
                    textAlign = TextAlign.Center
                )
            )
        },
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(
                    text = stringResource(R.string.warning_default_confirm),
                    style = AppTheme.typography.bodySmallBold,
                    color = AppTheme.colors.lightRed
                )
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text(
                    text = stringResource(R.string.warning_default_dismiss),
                    style = AppTheme.typography.bodySmallBold,
                    color = AppTheme.colors.baseBlue
                )
            }
        },
        containerColor = AppTheme.colors.superLightPeachy,
        titleContentColor = AppTheme.colors.baseBlue,
        textContentColor = AppTheme.colors.baseBlueLight,
        iconContentColor = AppTheme.colors.lightRed
    )
}