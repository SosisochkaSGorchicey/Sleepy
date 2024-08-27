package com.feature.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.core.ui.theme.AppTheme

@Composable
fun StoriesDisplay() {
    LazyRow(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {//todo first and last items padding
        items(10) {
            Box(
                modifier = Modifier
                    .width(80.dp)
                    .aspectRatio(0.75f)
                    .clip(AppTheme.shapes.smallestCornersDp)
                    .background(Color.White)
                    .border(
                        width = 3.dp,
                        shape = AppTheme.shapes.smallestCornersDp,
                        color = AppTheme.colors.basePeachy
                    )

            )
        }
    }
}