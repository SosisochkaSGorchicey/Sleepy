package com.feature.home.presentation.screenmodel

import androidx.annotation.StringRes
import androidx.compose.runtime.Immutable
import com.core.domain.model.ArticleItem
import com.core.domain.model.supabase.StoryItem

@Immutable
data class HomeState(
    @StringRes val errorTextRes: Int? = null,
    val stories: List<StoryItem> = emptyList(),
    val articles: List<ArticleItem> = emptyList(),
)

sealed interface HomeEvent {
    data object OnAccountClick : HomeEvent
    data object OnSettingsClick : HomeEvent
}

sealed interface HomeSideEffect {
    data object NavigateToAccount : HomeSideEffect
    data object NavigateToSettings : HomeSideEffect
}