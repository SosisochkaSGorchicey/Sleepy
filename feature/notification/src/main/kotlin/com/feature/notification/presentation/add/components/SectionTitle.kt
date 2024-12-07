package com.feature.notification.presentation.add.components

import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.core.ui.theme.AppTheme

@Composable
fun SectionTitle(@StringRes textRes: Int) {
    Text(
        text = stringResource(textRes),
        style = AppTheme.typography.bodyMediumBold
    )
}