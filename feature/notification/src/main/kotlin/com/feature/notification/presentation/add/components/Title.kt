package com.feature.notification.presentation.add.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.core.ui.R
import com.core.ui.theme.AppTheme

@Composable
fun Title(modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(.6f)
                .offset(x = 2.dp, y = 1.dp),
            text = stringResource(R.string.add_notification_title),
            style = AppTheme.typography.bodyLargeBold,
            color = AppTheme.colors.white
        )

        Text(
            modifier = Modifier.fillMaxWidth(.6f),
            text = stringResource(R.string.add_notification_title),
            style = AppTheme.typography.bodyLargeBold
        )
    }
}