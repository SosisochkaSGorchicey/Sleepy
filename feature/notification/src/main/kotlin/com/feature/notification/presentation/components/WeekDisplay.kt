package com.feature.notification.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.core.ui.theme.AppTheme
import com.feature.notification.model.WeekItem
import com.feature.notification.presentation.screenmodel.NotificationEvent
import com.feature.notification.presentation.screenmodel.NotificationState

@Composable
fun WeekDisplay(
    state: NotificationState,
    onEvent: (NotificationEvent) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        WeekItem.entries.forEach { weekItem ->
            WeekItemDisplay(
                weekItem = weekItem,
                isSelected = state.selectedWeekItem == weekItem,
                onClick = { onEvent(NotificationEvent.OnWeekItemClick(weekItem = weekItem)) }
            )
        }
    }
}

@Composable
private fun RowScope.WeekItemDisplay(
    weekItem: WeekItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .weight(1f)
            .clip(AppTheme.shapes.mediumCornersPercent)
            .background(
                color = if (isSelected) AppTheme.colors.baseBlue
                else AppTheme.colors.transparent
            )
            .border(
                width = 1.dp,
                color = AppTheme.colors.baseBlue,
                shape = AppTheme.shapes.mediumCornersPercent
            )
            .clickable(onClick = onClick)
            .padding(vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = weekItem.shortName,
            color = if (isSelected) AppTheme.colors.white
            else AppTheme.colors.baseBlue,
            style = AppTheme.typography.bodySmallBold
        )
    }
}