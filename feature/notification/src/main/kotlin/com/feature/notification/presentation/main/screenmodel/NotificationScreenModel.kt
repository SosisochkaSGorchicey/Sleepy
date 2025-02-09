package com.feature.notification.presentation.main.screenmodel

import com.core.common.mvi.MviScreenModel
import com.core.common.mvi.emitSideEffect
import com.core.common.mvi.reducer
import com.core.domain.repository.DataStoreRepository
import com.core.domain.repository.FirestoreRepository
import com.core.domain.usecase.ObserveScheduleItemUseCase
import com.feature.notification.model.WeekItem
import com.feature.notification.model.getWeekDayById
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.isoDayNumber
import kotlinx.datetime.toLocalDateTime
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class NotificationScreenModel(
    private val dataStoreRepository: DataStoreRepository,
    private val firestoreRepository: FirestoreRepository,
    private val observeScheduleItemUseCase: ObserveScheduleItemUseCase
) : MviScreenModel<NotificationState, NotificationSideEffect, NotificationEvent>(
    initialState = NotificationState()
) {

    init {
        decideScreenState()
        setDefaultDay()
        observeSchedule()
    }

    private fun observeSchedule() = intent {
        observeScheduleItemUseCase()
    }

    override fun onEvent(event: NotificationEvent) {
        when (event) {
            NotificationEvent.OnOnboardingCardClick -> onboardingCardDisappear()
            is NotificationEvent.OnWeekItemClick -> changeSelectedWeekItem(selectedWeekItem = event.weekItem)
            NotificationEvent.OnAddButtonClick -> emitSideEffect(NotificationSideEffect.NavigateToAddScreen())
            NotificationEvent.OnClearCurrentDayClick -> clearCurrentDay()
            NotificationEvent.OnCloseDropDownMenu -> closeDropDownMenu()
            NotificationEvent.OnDeleteAllClick -> deleteAll()
            NotificationEvent.OnDropDownMenuClick -> changeDropDownMenu()
            is NotificationEvent.OnOpenAlertDialog -> changeAlertDialog(alertDialog = event.alertDialog)
            NotificationEvent.CloseAlertDialog -> changeAlertDialog()
            is NotificationEvent.OnItemSwipeToDelete -> deleteItemById(id = event.itemId)
            is NotificationEvent.OnItemClick -> emitSideEffect(
                NotificationSideEffect.NavigateToAddScreen(scheduleItem = event.scheduleItem)
            )
        }
    }

    private fun deleteItemById(id: String) {
//        id?.let { todo
//            intent { localDatabaseRepository.deleteById(id = it) }
//            changeAlertDialog()
//        }
    }

    private fun clearCurrentDay() = intent {
//        state.selectedWeekItems?.let { list -> todo
//            if (list.firstOrNull() != null) {
//                intent { localDatabaseRepository.deleteForWeekDay(weekDayId = list.first().id) }
//                changeAlertDialog()
//            }
//        }
    }

    private fun deleteAll() {
//        intent { localDatabaseRepository.deleteAll() } todo
//        changeAlertDialog()
    }

    private fun changeAlertDialog(alertDialog: AlertDialog? = null) =
        reducer {
            closeDropDownMenu()
            state.copy(currentAlertDialog = alertDialog)
        }


    private fun changeDropDownMenu() =
        reducer { state.copy(dropDownIsExtended = !state.dropDownIsExtended) }

    private fun closeDropDownMenu() =
        reducer { state.copy(dropDownIsExtended = false) }

    private fun setDefaultDay() {
        val currentDayOfWeek = Clock.System.now()
            .toLocalDateTime(TimeZone.currentSystemDefault())
            .dayOfWeek.isoDayNumber

        (currentDayOfWeek - 1).getWeekDayById()?.let { weekItem ->
            reducer { state.copy(selectedWeekItems = listOf(weekItem)) }
            getItemsForWeek(idOfWeekItem = weekItem.id)
        }
    }

    private fun changeSelectedWeekItem(selectedWeekItem: WeekItem) {
        reducer { state.copy(selectedWeekItems = listOf(selectedWeekItem)) }
        getItemsForWeek(idOfWeekItem = selectedWeekItem.id)
    }

    private fun getItemsForWeek(idOfWeekItem: Int) = intent {
        firestoreRepository.scheduleItems.collect { listOfAll ->
            val filteredByWeekDay = listOfAll.filter {
                it.weekDayId == idOfWeekItem
            }
            reduce { state.copy(notificationItems = filteredByWeekDay) }
        }
    }

    private fun onboardingCardDisappear() =
        reducer { state.copy(showOnboardingCard = false) }

    private fun decideScreenState() = intent {
        dataStoreRepository.notificationOnboardingCompleted().collect {
            reduce {
                state.copy(
                    screenState = if (it) NotificationScreenState.Usual
                    else NotificationScreenState.Usual
                )
            }
        }
    }
}