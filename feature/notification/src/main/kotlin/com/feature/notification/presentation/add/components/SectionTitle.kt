package com.feature.notification.presentation.add.components

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.TooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.core.ui.theme.AppTheme

@Composable
fun SectionTitle(@StringRes textRes: Int) {
    Text(
        text = stringResource(textRes),
        style = AppTheme.typography.bodyMediumBold
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SectionTitleWithHint( //todo
    @StringRes textRes: Int,
    onClick: () -> Unit
) {
    val tooltipState = remember { TooltipState() }
    val tooltipPosition = TooltipDefaults.rememberPlainTooltipPositionProvider()

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = stringResource(textRes),
            style = AppTheme.typography.bodyMediumBold
        )

        TooltipBox(
            tooltip = { Text("Add to favorites") },
            state = tooltipState,
            positionProvider = tooltipPosition
        ) {
            Icon(
                modifier = Modifier
                    .clip(AppTheme.shapes.rounded)
                    .clickable(onClick = onClick)
                    .padding(4.dp),
                imageVector = Icons.Outlined.Info,
                contentDescription = null
            )
        }
    }
}