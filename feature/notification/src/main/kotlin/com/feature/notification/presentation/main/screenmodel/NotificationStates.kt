package com.feature.notification.presentation.main.screenmodel

import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import com.core.domain.model.localDB.ScheduleItem
import com.feature.notification.model.WeekItem

@Immutable
data class NotificationState(
    val screenState: NotificationScreenState = NotificationScreenState.Loading,
    val showOnboardingCard: Boolean = true,
    val selectedWeekItems: List<WeekItem>? = null,
    val notificationItems: List<ScheduleItem> = emptyList(),
    val dropDownIsExtended: Boolean = false
)

sealed interface NotificationScreenState {
    data object Loading : NotificationScreenState
    data object Onboarding : NotificationScreenState
    data object Usual : NotificationScreenState
}

sealed interface NotificationEvent {
    data class OnOpenAlertDialog(
        @StringRes val warningTextRes: Int,
        val notificationEvent: NotificationEvent

    ) : NotificationEvent

    data object OnDeleteAllClick : NotificationEvent
    data object OnClearCurrentDayClick : NotificationEvent
    data object OnAddButtonClick : NotificationEvent
    data object OnOnboardingCardClick : NotificationEvent
    data object OnCloseDropDownMenu : NotificationEvent
    data object OnDropDownMenuClick : NotificationEvent
    data class OnWeekItemClick(val weekItem: WeekItem) : NotificationEvent
}

sealed interface NotificationSideEffect {
    data object NavigateToAddScreen : NotificationSideEffect
}