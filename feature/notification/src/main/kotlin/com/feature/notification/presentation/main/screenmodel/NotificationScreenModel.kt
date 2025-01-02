package com.feature.notification.presentation.main.screenmodel

import com.core.common.mvi.MviScreenModel
import com.core.common.mvi.emitSideEffect
import com.core.common.mvi.reducer
import com.core.domain.repository.DataStoreRepository
import com.core.domain.repository.LocalDatabaseRepository
import com.feature.notification.model.WeekItem
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class NotificationScreenModel(
    private val dataStoreRepository: DataStoreRepository,
    private val localDatabaseRepository: LocalDatabaseRepository
) : MviScreenModel<NotificationState, NotificationSideEffect, NotificationEvent>(
    initialState = NotificationState()
) {

    init {
        decideScreenState()

        intent { //todo
            localDatabaseRepository.itemsByWeekDayId(weekDayId = 0)
                .collect {
                    println("TAG: itemsByWeekDayId collect $it")
                }
        }
    }

    override fun onEvent(event: NotificationEvent) {
        when (event) {
            NotificationEvent.OnOnboardingCardClick -> onboardingCardDisappear()
            is NotificationEvent.OnWeekItemClick -> changeSelectedWeekItem(selectedWeekItem = event.weekItem)
            NotificationEvent.OnAddButtonClick -> emitSideEffect(NotificationSideEffect.NavigateToAddScreen)
        }
    }

    private fun changeSelectedWeekItem(selectedWeekItem: WeekItem) {
        //todo
        reducer { state.copy(selectedWeekItems = listOf(selectedWeekItem)) }
    }

    private fun onboardingCardDisappear() =
        reducer { state.copy(showOnboardingCard = false) }

    private fun decideScreenState() = intent {
        dataStoreRepository.notificationOnboardingCompleted().collect {
            reduce {
                state.copy(
                    screenState = if (it) NotificationScreenState.Usual
                    else NotificationScreenState.Onboarding
                )
            }
        }
    }
}