package com.feature.notification.presentation.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.core.ui.R
import com.feature.notification.presentation.commonItems.WeekDisplay
import com.feature.notification.presentation.main.screenmodel.AlertDialog
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

        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(
                items = state.notificationItems,
                key = { it.id ?: it.hashCode() }
            ) { notificationItem ->
                NotificationItemSwipeContainer(
                    notificationItem = notificationItem,
                    onItemClick = {}, //todo
                    onItemDelete = {
                        onEvent(
                            NotificationEvent.OnOpenAlertDialog(
                                alertDialog = AlertDialog(
                                    warningTextRes = R.string.warning_item_delete,
                                    notificationEvent = NotificationEvent.OnItemSwipeToDelete(itemId = notificationItem.id)
                                )
                            )
                        )
                    },
                    dismiss = state.currentAlertDialog != null
                )
            }
        }
    }
}