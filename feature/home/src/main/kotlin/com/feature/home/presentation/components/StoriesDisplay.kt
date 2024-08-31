package com.feature.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.core.ui.theme.AppTheme
import com.feature.home.presentation.screenmodel.HomeState
import com.feature.home.utils.toPadding

@Composable
fun StoriesDisplay(state: HomeState) {
    LazyRow(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        itemsIndexed(state.stories) { index, story ->
            Box(
                modifier = Modifier
                    .then(index.toPadding(lastIndex = state.stories.lastIndex))
                    .width(80.dp)
                    .aspectRatio(0.75f)
                    .clip(AppTheme.shapes.smallestCornersDp)
                    .background(Color.White)
                    .border(
                        width = 3.dp,
                        shape = AppTheme.shapes.smallestCornersDp,
                        color = AppTheme.colors.basePeachy
                    )
                    .clickable { }

            )
        }
    }
}