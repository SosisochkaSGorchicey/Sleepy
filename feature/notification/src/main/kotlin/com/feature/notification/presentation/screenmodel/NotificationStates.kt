package com.feature.notification.presentation.screenmodel

import androidx.compose.runtime.Immutable

@Immutable
data class NotificationState(
    val screenState: NotificationScreenState = NotificationScreenState.Loading,
    val showOnboardingCard: Boolean = true,
)

sealed interface NotificationScreenState {
    data object Loading : NotificationScreenState
    data object Onboarding : NotificationScreenState
    data object Usual : NotificationScreenState
}

sealed interface NotificationEvent {
    data object OnOnboardingCardClick: NotificationEvent
}

sealed interface NotificationSideEffect {

}