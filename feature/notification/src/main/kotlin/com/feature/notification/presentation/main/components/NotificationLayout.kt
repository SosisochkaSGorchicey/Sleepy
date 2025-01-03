package com.feature.notification.presentation.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.feature.notification.presentation.commonItems.WeekDisplay
import com.feature.notification.presentation.main.screenmodel.NotificationEvent
import com.feature.notification.presentation.main.screenmodel.NotificationState

@Composable
fun NotificationLayout(
    modifier: Modifier,
    state: NotificationState,
    onEvent: (NotificationEvent) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        WeekDisplay(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
            selectedWeekItems = state.selectedWeekItems,
            onClick = { onEvent(NotificationEvent.OnWeekItemClick(weekItem = it)) }
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
        ) {
            state.notificationItems.forEach { notificationItem ->
                NotificationItemDisplay(
                    notificationItem = notificationItem,
                    onItemClick = {}
                )
            }
        }
    }
}