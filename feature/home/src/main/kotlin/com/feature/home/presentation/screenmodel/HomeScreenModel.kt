package com.feature.home.presentation.screenmodel

import com.core.common.mvi.MviScreenModel
import com.core.common.mvi.emitSideEffect
import com.core.common.mvi.reducer
import com.core.domain.model.ArticleItem
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
        reducer { //todo
            state.copy(
                articles = listOf(
                    ArticleItem(
                        id = 0,
                        title = "Title 1",
                        description = ",mk nbgvcd jkcnjdshncijs cdsijncijdshc",
                        backgroundImageUrl = " mnkjbgh"
                    ),
                    ArticleItem(
                        id = 0,
                        title = "Title 2",
                        description = ",mk nbgvcd jkcnjdshncijs cdsijncijdshc",
                        backgroundImageUrl = " mnkjbgh"
                    ),
                    ArticleItem(
                        id = 0,
                        title = "Title 3",
                        description = ",mk nbgvcd jkcnjdshncijs cdsijncijdshc",
                        backgroundImageUrl = " mnkjbgh",
                        isFullSize = true
                    ),
                    ArticleItem(
                        id = 0,
                        title = "Title 4",
                        description = ",mk nbgvcd jkcnjdshncijs cdsijncijdshc",
                        backgroundImageUrl = " mnkjbgh"
                    ),
                    ArticleItem(
                        id = 0,
                        title = "Title 5",
                        description = ",mk nbgvcd jkcnjdshncijs cdsijncijdshc",
                        backgroundImageUrl = " mnkjbgh"
                    ),
                    ArticleItem(
                        id = 0,
                        title = "Title 6",
                        description = ",mk nbgvcd jkcnjdshncijs cdsijncijdshc",
                        backgroundImageUrl = " mnkjbgh",
                        isFullSize = true
                    ),
                    ArticleItem(
                        id = 0,
                        title = "Title 7",
                        description = ",mk nbgvcd jkcnjdshncijs cdsijncijdshc",
                        backgroundImageUrl = " mnkjbgh",
                        isFullSize = true
                    )
                )
            )
        }
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