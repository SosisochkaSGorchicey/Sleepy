package com.core.ui.uiElements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.core.ui.theme.AppTheme

@Composable
fun ErrorSnackbar(
    modifier: Modifier,
    errorTextRes: Int,
    content: @Composable () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .clip(AppTheme.shapes.mediumCornersPercent)
                    .background(AppTheme.colors.lightPeachy)
                    .padding(10.dp),
                text = stringResource(errorTextRes),
                color = AppTheme.colors.baseBlue,
                style = AppTheme.typography.bodyMedium.copy(textAlign = TextAlign.Center)
            )

            content()
        }
    }
}