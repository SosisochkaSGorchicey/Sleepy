package com.feature.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.feature.home.presentation.screenmodel.HomeState


fun LazyGridScope.articleCardsDisplay(
    state: HomeState
) {
    items(
        items = state.articles,
        // = state.articles,
        span = {
            GridItemSpan(if (it.isFullSize) maxLineSpan else 1)
        }
    ) {
        ArticleCard()
    }
}

@Composable
private fun ArticleCard() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.Red)
    )
}

