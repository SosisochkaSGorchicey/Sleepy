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
    val dropDownIsExtended: Boolean = false,
    val currentAlertDialog: AlertDialog? = null
)

sealed interface NotificationEvent {
    data class OnItemSwipeToDelete(val itemId: String) : NotificationEvent
    data object CloseAlertDialog : NotificationEvent
    data class OnOpenAlertDialog(val alertDialog: AlertDialog) : NotificationEvent
    data object OnDeleteAllClick : NotificationEvent
    data object OnClearCurrentDayClick : NotificationEvent
    data object OnAddButtonClick : NotificationEvent
    data object OnOnboardingCardClick : NotificationEvent
    data object OnCloseDropDownMenu : NotificationEvent
    data object OnDropDownMenuClick : NotificationEvent
    data class OnItemClick(val scheduleItem: ScheduleItem) : NotificationEvent
    data class OnWeekItemClick(val weekItem: WeekItem) : NotificationEvent
}

sealed interface NotificationSideEffect {
    data class NavigateToAddScreen(val scheduleItem: ScheduleItem? = null) : NotificationSideEffect
}

sealed interface NotificationScreenState { //todo
    data object Loading : NotificationScreenState
    data object Usual : NotificationScreenState
}

data class AlertDialog(
    @StringRes val warningTextRes: Int,
    val notificationEvent: NotificationEvent
)