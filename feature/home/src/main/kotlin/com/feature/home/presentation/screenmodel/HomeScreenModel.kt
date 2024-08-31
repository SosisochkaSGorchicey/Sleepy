package com.feature.home.presentation.screenmodel

import com.core.common.mvi.MviScreenModel
import com.core.common.mvi.emitSideEffect
import com.core.domain.model.supabase.SupabaseResult
import com.core.domain.repository.SupabaseDatabaseRepository
import com.feature.home.utils.toTextRes
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class HomeScreenModel(
    private val supabaseDatabaseRepository: SupabaseDatabaseRepository
) : MviScreenModel<HomeState, HomeSideEffect, HomeEvent>(
    initialState = HomeState()
) {

    init {
        initStories()
    }

    override fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.OnAccountClick -> emitSideEffect(HomeSideEffect.NavigateToAccount)
            HomeEvent.OnSettingsClick -> emitSideEffect(HomeSideEffect.NavigateToSettings)
        }
    }

    private fun initStories() = intent {
        val result = supabaseDatabaseRepository.getStories()
        when {
            result is SupabaseResult.Error -> reduce {
                state.copy(errorTextRes = result.errorType.toTextRes())
            }

            result is SupabaseResult.Success -> reduce {
                state.copy(stories = result.data + result.data) //todo?
            }
        }
    }
}