package com.feature.home.presentation.screenmodel

import com.core.common.mvi.MviScreenModel
import com.core.common.mvi.emitSideEffect
import com.core.common.mvi.reducer
import com.core.domain.model.ArticleItem
import com.core.domain.model.supabase.StoryItem
import com.core.domain.model.supabase.SupabaseResult
import com.core.domain.repository.SupabaseDatabaseRepository
import com.feature.home.mapper.toPresentation
import com.feature.home.utils.toTextRes
import org.orbitmvi.orbit.syntax.simple.intent

class HomeScreenModel(
    private val supabaseDatabaseRepository: SupabaseDatabaseRepository
) : MviScreenModel<HomeState, HomeSideEffect, HomeEvent>(
    initialState = HomeState()
) {

    init {
        dataLoad()
    }

    override fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.OnAccountClick -> emitSideEffect(HomeSideEffect.NavigateToAccount)
            HomeEvent.OnSettingsClick -> emitSideEffect(HomeSideEffect.NavigateToSettings)
            HomeEvent.RetryDataLoad -> dataLoad()
        }
    }

    private fun dataLoad() {
        initStories()
        initArticles()
    }

    private fun <T> SupabaseResult<T>.observeResult(successAction: (T) -> Unit) {
        when (this) {
            is SupabaseResult.Error -> reducer {
                state.copy(
                    inLoading = false,
                    errorTextRes = this@observeResult.errorType.toTextRes()
                )
            }

            SupabaseResult.Loading ->
                reducer { state.copy(inLoading = true, errorTextRes = null) }

            is SupabaseResult.Success -> {
                successAction(this.data)
                reducer { state.copy(inLoading = false, errorTextRes = null) }
            }
        }
    }

    private fun articlesDataChange(newData: List<ArticleItem>) {
        reducer { state.copy(articles = newData.map { it.toPresentation() }) }
    }

    private fun storiesDataChange(newData: List<StoryItem>) {
        reducer { state.copy(stories = newData) }
    }

    private fun initArticles() = intent {
        supabaseDatabaseRepository.articles().collect {
            it.observeResult(successAction = ::articlesDataChange)
        }
    }

    private fun initStories() = intent {
        supabaseDatabaseRepository.stories().collect {
            it.observeResult(successAction = ::storiesDataChange)
        }
    }
}