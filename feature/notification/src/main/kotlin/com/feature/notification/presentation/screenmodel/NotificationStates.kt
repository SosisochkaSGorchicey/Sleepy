package com.feature.notification.presentation.screenmodel

import androidx.compose.runtime.Immutable
import com.feature.notification.model.WeekItem

@Immutable
data class NotificationState(
    val screenState: NotificationScreenState = NotificationScreenState.Loading,
    val showOnboardingCard: Boolean = true,
    val selectedWeekItem: WeekItem? = null
)

sealed interface NotificationScreenState {
    data object Loading : NotificationScreenState
    data object Onboarding : NotificationScreenState
    data object Usual : NotificationScreenState
}

sealed interface NotificationEvent {
    data object OnOnboardingCardClick : NotificationEvent
    data class OnWeekItemClick(val weekItem: WeekItem) : NotificationEvent
}

sealed interface NotificationSideEffect {

}