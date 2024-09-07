package com.feature.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.core.domain.model.ArticleItem
import com.core.ui.theme.AppTheme
import com.core.ui.uiElements.ErrorDisplay
import com.core.ui.uiElements.ShimmerDisplay
import com.feature.home.presentation.screenmodel.HomeState


fun LazyGridScope.articleCardsDisplay(
    state: HomeState,
    modifier: Modifier
) {
    items(
        items = state.articles,
        span = {
            GridItemSpan(if (it.isFullSize) maxLineSpan else 1)
        }
    ) { articleItem ->
        ArticleCard(
            articleItem = articleItem,
            modifier = if (articleItem == state.articles.last()) modifier.padding(bottom = 16.dp)
            else Modifier
        )
    }
}

@Composable
private fun ArticleCard(
    articleItem: ArticleItem,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .aspectRatio(if (articleItem.isFullSize) 2.5f else 1.5f)
            .clip(AppTheme.shapes.smallCornersDp)
            .background(AppTheme.colors.milkyWhite)
            .border(
                width = 2.dp,
                shape = AppTheme.shapes.smallCornersDp,
                color = AppTheme.colors.baseGray
            )
    ) {
        ArticleCardImage(

            imageRes = articleItem.backgroundImageUrl
        )

        ArticleCardTextDisplay(articleItem = articleItem)
    }
}

@Composable
private fun ArticleCardImage(
    imageRes: String?
) {
    imageRes?.let {
        SubcomposeAsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = "https://orvecjxgikqmjfshqkms.supabase.co/storage/v1/object/public/Stories/content/story2.png?t=2024-09-01T17%3A59%3A50.166Z",
            //articleItem.backgroundImageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            loading = {
                ShimmerDisplay(background = AppTheme.colors.baseGray)
            },
            error = {
                ErrorDisplay(tintColor = AppTheme.colors.basePeachy)
            }
        )
    } ?: Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(
                        Color.Green, Color.Blue
                    )
                )
            )
    )
}

@Composable
private fun ArticleCardTextDisplay(articleItem: ArticleItem) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = articleItem.title,
            style = AppTheme.typography.bodyMediumBold
        )

        articleItem.description?.let {
            Text(
                text = it,
                overflow = TextOverflow.Ellipsis,
                style = AppTheme.typography.bodySmall
            )
        }
    }
}

