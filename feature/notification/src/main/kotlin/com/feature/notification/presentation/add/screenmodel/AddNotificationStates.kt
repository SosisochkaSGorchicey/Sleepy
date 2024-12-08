package com.feature.notification.presentation.add.screenmodel

import androidx.compose.runtime.Immutable
import com.feature.notification.model.WeekItem

@Immutable
data class AddNotificationState(
    val chosenWeekDays: List<WeekItem> = emptyList(),
)

sealed interface AddNotificationEvent {
    data object OnBackButtonClick : AddNotificationEvent
    data class OnWeekItemClick(val clickedWeekItem: WeekItem) : AddNotificationEvent
}

sealed interface AddNotificationSideEffect {
    data object NavigateBack : AddNotificationSideEffect
}