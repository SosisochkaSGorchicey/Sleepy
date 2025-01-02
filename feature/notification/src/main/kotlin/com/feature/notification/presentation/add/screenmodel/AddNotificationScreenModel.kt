package com.feature.notification.presentation.add.screenmodel

import com.core.common.mvi.MviScreenModel
import com.core.common.mvi.blockingReducer
import com.core.common.mvi.emitSideEffect
import com.core.common.mvi.reducer
import com.core.domain.model.localDB.ScheduleItem
import com.core.domain.repository.LocalDatabaseRepository
import com.feature.notification.model.WeekItem
import kotlinx.coroutines.delay
import kotlinx.datetime.LocalTime
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class AddNotificationScreenModel(
    private val localDatabaseRepository: LocalDatabaseRepository
) : MviScreenModel<AddNotificationState, AddNotificationSideEffect, AddNotificationEvent>(
    initialState = AddNotificationState()
) {
    override fun onEvent(event: AddNotificationEvent) {
        when (event) {
            is AddNotificationEvent.OnWeekItemClick -> weekItemClickLogic(weekItem = event.clickedWeekItem)
            AddNotificationEvent.OnBackButtonClick -> emitSideEffect(AddNotificationSideEffect.NavigateBack)
            is AddNotificationEvent.OnSwitchClick -> switchStateChange(newValue = event.value)
            AddNotificationEvent.OnDaysHintClick -> daysHintVisibilityChange()
            is AddNotificationEvent.OnTimeSelect -> timeSelected(localTime = event.localTime)
            is AddNotificationEvent.OnDescriptionChange -> changeDescription(newValue = event.newValue)
            is AddNotificationEvent.OnTitleChange -> changeTitle(newValue = event.newValue)
            AddNotificationEvent.OnSaveClick -> saveItem()
        }
    }

    private fun saveItem() = intent {
        //todo checks
        state.chosenWeekItems.forEach { weekItem ->
            localDatabaseRepository.saveScheduleItem(
                scheduleItem = ScheduleItem(
                    createPush = state.createNotification,
                    weekDayId = weekItem.id,
                    millisecondOfDay = state.selectedTime?.toMillisecondOfDay() ?: 0,
                    titleText = state.titleText,
                    descriptionText = state.descriptionText
                )
            )
        }
    }

    private fun changeDescription(newValue: String) =
        blockingReducer { state.copy(descriptionText = newValue) }

    private fun changeTitle(newValue: String) =
        blockingReducer { state.copy(titleText = newValue) }

    private fun timeSelected(localTime: LocalTime) =
        reducer { state.copy(selectedTime = localTime) }

    private fun daysHintVisibilityChange() = intent {
        if (state.daysHintIsVisible) {
            reduce { state.copy(daysHintIsVisible = false) }
        } else {
            reduce { state.copy(daysHintIsVisible = true) }
            delay(2000)
            reduce { state.copy(daysHintIsVisible = false) }
        }
    }

    private fun switchStateChange(newValue: Boolean) =
        reducer { state.copy(createNotification = newValue) }

    private fun weekItemClickLogic(weekItem: WeekItem) = intent {
        when {
            state.chosenWeekItems.size == 1 && state.chosenWeekItems.contains(weekItem) -> reduce {
                state.copy(chosenWeekItems = state.chosenWeekItems.filterNot { it == weekItem })
            }

            state.chosenWeekItems.isEmpty() -> reduce {
                state.copy(chosenWeekItems = listOf(weekItem))
            }

            state.chosenWeekItems.size == 1 -> reduce {
                val firstIndex = WeekItem.entries.indexOf(state.chosenWeekItems.first())
                val secondIndex = WeekItem.entries.indexOf(weekItem)
                state.copy(
                    chosenWeekItems = WeekItem.entries.slice(
                        indices = if (secondIndex > firstIndex) firstIndex..secondIndex
                        else secondIndex..firstIndex
                    )
                )
            }

            else -> reduce {
                state.copy(chosenWeekItems = emptyList())
            }
        }
    }
}