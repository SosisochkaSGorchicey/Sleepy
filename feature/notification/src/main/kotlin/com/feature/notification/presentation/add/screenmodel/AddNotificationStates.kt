package com.feature.notification.presentation.add.screenmodel

import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import com.feature.notification.model.WeekItem
import kotlinx.datetime.LocalTime

@Immutable
data class AddNotificationState(
    val createNotification: Boolean = true,
    val daysHintIsVisible: Boolean = false,
    val chosenWeekItems: List<WeekItem> = emptyList(),
    val selectedTime: LocalTime = LocalTime(0, 0),
    val titleText: String = "",
    val descriptionText: String = "",
    @StringRes val errorTextRes: Int? = null
) {
    fun daysAreChosen(): Boolean = chosenWeekItems.isNotEmpty()

    fun textsAreValid(): Boolean = titleText.isNotBlank() && descriptionText.isNotBlank()
}

sealed interface AddNotificationEvent {
    data object OnBackButtonClick : AddNotificationEvent
    data object OnDaysHintClick : AddNotificationEvent
    data object OnSaveClick : AddNotificationEvent
    data class OnSwitchClick(val value: Boolean) : AddNotificationEvent
    data class OnWeekItemClick(val clickedWeekItem: WeekItem) : AddNotificationEvent
    data class OnTimeSelect(val localTime: LocalTime) : AddNotificationEvent
    data class OnTitleChange(val newValue: String) : AddNotificationEvent
    data class OnDescriptionChange(val newValue: String) : AddNotificationEvent
}

sealed interface AddNotificationSideEffect {
    data object NavigateBack : AddNotificationSideEffect
}