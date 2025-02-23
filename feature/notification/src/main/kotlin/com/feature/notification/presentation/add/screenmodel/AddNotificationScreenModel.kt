package com.feature.notification.presentation.add.screenmodel

import com.core.common.mvi.MviScreenModel
import com.core.common.mvi.blockingReducer
import com.core.common.mvi.emitSideEffect
import com.core.common.mvi.reducer
import com.core.domain.model.localDB.ScheduleItem
import com.core.domain.usecase.storage.CreateScheduleItemUseCase
import com.core.domain.usecase.storage.UpdateAllSimilarScheduleItemsUseCase
import com.core.domain.usecase.storage.UpdateScheduleItemUseCase
import com.core.ui.R
import com.core.ui.utils.millisecondsToLocalTime
import com.feature.notification.model.WeekItem
import com.feature.notification.model.getWeekDayById
import kotlinx.coroutines.delay
import kotlinx.datetime.LocalTime
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

class AddNotificationScreenModel(
    private val createScheduleItemUseCase: CreateScheduleItemUseCase,
    private val scheduleItem: ScheduleItem?,
    private val updateScheduleItemUseCase: UpdateScheduleItemUseCase,
    private val updateAllSimilarScheduleItemsUseCase: UpdateAllSimilarScheduleItemsUseCase
) : MviScreenModel<AddNotificationState, AddNotificationSideEffect, AddNotificationEvent>(
    initialState = AddNotificationState(
        selectedTime = scheduleItem?.millisecondOfDay?.millisecondsToLocalTime() ?: LocalTime(0, 0),
        canEditWeekDays = scheduleItem == null // если update - нельзя менять weekday
    )
) {

    init {
        initData()
    }

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
            AddNotificationEvent.OnUpdateAllClick -> updateAllDays()
            AddNotificationEvent.OnUpdateOnlyCurrentClick -> updateOnlyCurrentDay()
            AddNotificationEvent.OnCloseUpdateDialog -> changeDialogDialogBeforeUpdateVisibility()
        }
    }

    private fun initData() {
        scheduleItem?.let { item ->
            reducer {
                state.copy(
                    createNotification = item.createPush,
                    chosenWeekItems = item.weekDayId.getWeekDayById()?.let { listOf(it) }
                        ?: emptyList(),
                    titleText = item.titleText,
                    descriptionText = item.descriptionText
                )
            }
        }
    }

    private fun updateItem(scheduleItem: ScheduleItem) = intent {
        updateScheduleItemUseCase(
            scheduleItem = scheduleItem.copy(
                createPush = state.createNotification,
                millisecondOfDay = state.selectedTime.toMillisecondOfDay(),
                titleText = state.titleText,
                descriptionText = state.descriptionText
            )
        )
    }

    private fun createItem(weekItemId: Int) = intent {
        createScheduleItemUseCase(
            scheduleItem = ScheduleItem(
                createPush = state.createNotification,
                weekDayId = weekItemId,
                millisecondOfDay = state.selectedTime.toMillisecondOfDay(),
                titleText = state.titleText,
                descriptionText = state.descriptionText
            )
        )
    }


    private fun saveItem() = intent {
        when {
            !state.daysAreChosen() -> showError(R.string.error_no_days_selected)
            !state.textsAreValid() -> showError(R.string.error_empty_text_fields)
            else -> {
                if (scheduleItem == null) { // создание нового айтема
                    state.chosenWeekItems.forEach { weekItem ->
                        createItem(weekItemId = weekItem.id)
                    }
                    emitSideEffect(AddNotificationSideEffect.NavigateBack)
                } else { //апдейт старого айтема
                    changeDialogDialogBeforeUpdateVisibility()
                }
            }
        }
    }

    private fun changeDialogDialogBeforeUpdateVisibility() =
        reducer { state.copy(showAlertDialogBeforeUpdate = !state.showAlertDialogBeforeUpdate) }

    private fun updateOnlyCurrentDay() = intent {
        changeDialogDialogBeforeUpdateVisibility()
        if (scheduleItem != null) updateItem(scheduleItem = scheduleItem)
        postSideEffect(AddNotificationSideEffect.NavigateBack)
    }

    private fun updateAllDays() = intent {
        changeDialogDialogBeforeUpdateVisibility()
        if (scheduleItem != null) {
            updateAllSimilarScheduleItemsUseCase(
                oldScheduleItem = scheduleItem,
                updatedScheduleItem = scheduleItem.copy(
                    createPush = state.createNotification,
                    millisecondOfDay = state.selectedTime.toMillisecondOfDay(),
                    titleText = state.titleText,
                    descriptionText = state.descriptionText
                )
            )
        }
        postSideEffect(AddNotificationSideEffect.NavigateBack)
    }

    private fun showError(errorTextRes: Int) = intent {
        reduce { state.copy(errorTextRes = errorTextRes) }
        delay(3000)
        reduce { state.copy(errorTextRes = null) }
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