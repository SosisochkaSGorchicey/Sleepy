package com.feature.notification.presentation.add.screenmodel

import com.core.common.mvi.MviScreenModel
import com.core.common.mvi.emitSideEffect
import com.core.common.mvi.reducer
import com.feature.notification.model.WeekItem
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class AddNotificationScreenModel
    : MviScreenModel<AddNotificationState, AddNotificationSideEffect, AddNotificationEvent>(
    initialState = AddNotificationState()
) {
    override fun onEvent(event: AddNotificationEvent) {
        when (event) {
            is AddNotificationEvent.OnWeekItemClick -> weekItemClickLogic(weekItem = event.clickedWeekItem)
            AddNotificationEvent.OnBackButtonClick -> emitSideEffect(AddNotificationSideEffect.NavigateBack)
            is AddNotificationEvent.OnSwitchClick -> switchStateChange(newValue = event.value)
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