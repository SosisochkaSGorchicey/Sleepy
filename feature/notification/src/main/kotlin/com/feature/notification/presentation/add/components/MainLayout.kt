package com.feature.notification.presentation.add.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.core.ui.R
import com.core.ui.uiElements.MainButton
import com.core.ui.uiElements.MainTextField
import com.feature.notification.presentation.add.screenmodel.AddNotificationEvent
import com.feature.notification.presentation.add.screenmodel.AddNotificationState
import com.feature.notification.presentation.commonItems.WeekDisplay

@Composable
fun MainLayout(
    padding: PaddingValues,
    state: AddNotificationState,
    onEvent: (AddNotificationEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(bottom = padding.calculateBottomPadding())
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Title(modifier = Modifier.padding(top = padding.calculateTopPadding()))

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

        SectionTitle(
            modifier = Modifier.padding(top = 20.dp),
            textRes = R.string.section_title_time
        )

        TimeSelector(
            onTimeSelected = { onEvent(AddNotificationEvent.OnTimeSelect(it)) },
            startTime = state.selectedTime
        )

        SectionTitle(textRes = R.string.section_title_title)

        MainTextField(
            currentText = state.titleText,
            placeholderText = stringResource(id = R.string.placeholder_add_notification),
            onValueChange = { onEvent(AddNotificationEvent.OnTitleChange(it)) }
        )

        SectionTitle(textRes = R.string.section_title_title)

        MainTextField(
            currentText = state.descriptionText,
            placeholderText = stringResource(id = R.string.placeholder_add_notification),
            onValueChange = { onEvent(AddNotificationEvent.OnDescriptionChange(it)) },
            singleLine = false,
            lines = 3
        )

        MainButton(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxWidth(),
            onClick = { onEvent(AddNotificationEvent.OnSaveClick) },
            text = stringResource(id = R.string.save_button)
        )
    }
}