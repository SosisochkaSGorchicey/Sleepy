package com.feature.notification.presentation.components

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.core.ui.theme.AppTheme
import com.feature.notification.model.NotificationItem

@Composable
fun NotificationItemDisplay(notificationItem: NotificationItem) {
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
            text = notificationItem.timeDisplay,
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
                .clip(AppTheme.shapes.rounded)
                .background(Color.Red)
                .padding(16.dp)
        ) {

        }
    }
}