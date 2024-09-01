package com.feature.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.core.domain.model.supabase.StoryItem
import com.core.ui.theme.AppTheme
import com.core.ui.uiElements.ErrorDisplay
import com.core.ui.uiElements.LoadingDisplay
import com.feature.home.presentation.screenmodel.HomeState
import com.feature.home.utils.toPadding

@Composable
fun StoriesDisplay(state: HomeState) {
    LazyRow(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .background(AppTheme.colors.baseBlue.copy(alpha = .5f))
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        itemsIndexed(state.stories) { index, story ->
            StoryPreviewUI(
                modifier = Modifier.then(index.toPadding(lastIndex = state.stories.lastIndex)),
                storyItem = story
            )
        }
    }
}

@Composable
private fun StoryPreviewUI(
    modifier: Modifier,
    storyItem: StoryItem
) {
    SubcomposeAsyncImage(
        modifier = Modifier
            .then(modifier)
            .width(80.dp)
            .aspectRatio(0.75f)
            .clip(AppTheme.shapes.smallestCornersDp)
            .background(AppTheme.colors.baseBlueLight)
            .border(
                width = 3.dp,
                shape = AppTheme.shapes.smallestCornersDp,
                color = AppTheme.colors.basePeachy
            )
            .clickable { },
        model = storyItem.previewUrl,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        loading = {
            LoadingDisplay(modifier = Modifier)
        },
        error = {
            ErrorDisplay()
        }
    )
}