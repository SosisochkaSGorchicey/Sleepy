package com.feature.notification.presentation.main.screenmodel

import androidx.compose.runtime.Immutable
import com.feature.notification.model.NotificationItem
import com.feature.notification.model.WeekItem

@Immutable
data class NotificationState(
    val screenState: NotificationScreenState = NotificationScreenState.Loading,
    val showOnboardingCard: Boolean = true,
    val selectedWeekItem: WeekItem? = null,
    val notificationItems: List<NotificationItem> = listOf(
        NotificationItem(
            timeDisplay = "20:00",
            title = "Clear space",
            note = "Clean bedroom to be ready to go to sleep in a clean room"
        ),
        NotificationItem(
            timeDisplay = "20:20",
            title = "No phone",
            note = "Stop using phone from this time"
        ),
        NotificationItem(
            timeDisplay = "22:20",
            title = "Sleep",
            note = "Go to bed"
        )
    )
)

sealed interface NotificationScreenState {
    data object Loading : NotificationScreenState
    data object Onboarding : NotificationScreenState
    data object Usual : NotificationScreenState
}

sealed interface NotificationEvent {
    data object OnAddButtonClick : NotificationEvent
    data object OnOnboardingCardClick : NotificationEvent
    data class OnWeekItemClick(val weekItem: WeekItem) : NotificationEvent
}

sealed interface NotificationSideEffect {
    data object NavigateToAddScreen : NotificationSideEffect
}