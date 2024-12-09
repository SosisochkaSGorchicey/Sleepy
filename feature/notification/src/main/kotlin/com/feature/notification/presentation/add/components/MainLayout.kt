package com.feature.notification.presentation.add.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.core.ui.R
import com.feature.notification.presentation.add.screenmodel.AddNotificationEvent
import com.feature.notification.presentation.add.screenmodel.AddNotificationState
import com.feature.notification.presentation.commonItems.WeekDisplay

@Composable
fun MainLayout(
    modifier: Modifier,
    state: AddNotificationState,
    onEvent: (AddNotificationEvent) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Title()

        NotificationSwitchDisplay(
            checked = state.createNotification,
            onCheckedChange = { onEvent(AddNotificationEvent.OnSwitchClick(it)) }
        )

        SectionTitleWithHint(
            textRes = R.string.section_title_day,
            onClick = { onEvent(AddNotificationEvent.OnDaysHintClick) },
            hintTextRes = R.string.section_hint_day,
            visible = state.daysHintIsVisible
        )

        WeekDisplay(
            selectedWeekItems = state.chosenWeekItems,
            onClick = { onEvent(AddNotificationEvent.OnWeekItemClick(it)) }
        )
    }
}