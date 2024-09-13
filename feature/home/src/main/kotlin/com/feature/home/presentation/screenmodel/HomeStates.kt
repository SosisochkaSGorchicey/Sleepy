package com.feature.home.presentation.screenmodel

import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import com.core.domain.model.supabase.StoryItem
import com.feature.home.model.ArticleUIModel

@Immutable
data class HomeState(
    @StringRes val errorTextRes: Int? = null,
    val inLoading: Boolean = true,
    val stories: List<StoryItem> = List(7) { StoryItem() },
    val articles: List<ArticleUIModel> = emptyList(),
)

sealed interface HomeEvent {
    data object OnAccountClick : HomeEvent
    data object OnSettingsClick : HomeEvent
    data object RetryDataLoad : HomeEvent
}

sealed interface HomeSideEffect {
    data object NavigateToAccount : HomeSideEffect
    data object NavigateToSettings : HomeSideEffect
}