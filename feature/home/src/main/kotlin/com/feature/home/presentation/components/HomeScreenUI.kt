package com.feature.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.feature.home.presentation.screenmodel.HomeState

@Composable
fun HomeScreenUI(
    firstPaddings: Modifier,
    lastPaddings: Modifier,
    state: HomeState
) {
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.Center,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item(span = {
            GridItemSpan(maxLineSpan)
        }) {
            StoriesDisplay(
                state = state,
                modifier = firstPaddings
            )
        }

        articleCardsDisplay(
            state = state,
            modifier = lastPaddings
        )
    }
}