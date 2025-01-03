package com.feature.notification.presentation.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.core.domain.model.localDB.ScheduleItem
import com.core.ui.theme.AppTheme
import com.core.ui.utils.millisecondsToTime

@Composable
fun NotificationItemDisplay(
    notificationItem: ScheduleItem,
    onItemClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = notificationItem.millisecondOfDay.millisecondsToTime(),
            color = AppTheme.colors.black,
            style = AppTheme.typography.bodySmallBold
        )

        VerticalDivider(
            modifier = Modifier.fillMaxHeight(),
            color = AppTheme.colors.darkerGray,
            thickness = 1.dp,
        )

        Column(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .weight(5f)
                .clip(AppTheme.shapes.smallCornersDp)
                .background(AppTheme.colors.baseBlue)
                .clickable(onClick = onItemClick)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = notificationItem.titleText,
                color = AppTheme.colors.white,
                style = AppTheme.typography.bodyMediumMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = notificationItem.descriptionText,
                color = AppTheme.colors.white,
                style = AppTheme.typography.bodySmall,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}