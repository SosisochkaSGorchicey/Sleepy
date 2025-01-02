package com.feature.notification.presentation.add.screenmodel

import androidx.compose.runtime.Immutable
import com.feature.notification.model.WeekItem
import kotlinx.datetime.LocalTime

@Immutable
data class AddNotificationState(
    val createNotification: Boolean = true,
    val daysHintIsVisible: Boolean = false,
    val chosenWeekItems: List<WeekItem> = emptyList(),
    val selectedTime: LocalTime? = null
)

sealed interface AddNotificationEvent {
    data object OnBackButtonClick : AddNotificationEvent
    data object OnDaysHintClick : AddNotificationEvent
    data class OnSwitchClick(val value: Boolean) : AddNotificationEvent
    data class OnWeekItemClick(val clickedWeekItem: WeekItem) : AddNotificationEvent
    data class OnTimeSelect(val localTime: LocalTime) : AddNotificationEvent
}

sealed interface AddNotificationSideEffect {
    data object NavigateBack : AddNotificationSideEffect
}