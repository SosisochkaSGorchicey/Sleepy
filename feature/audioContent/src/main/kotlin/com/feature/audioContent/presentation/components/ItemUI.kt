package com.feature.audioContent.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.core.domain.model.AudioDataItem
import com.core.ui.icons.MyIconPack
import com.core.ui.icons.myiconpack.Flame
import com.core.ui.theme.AppTheme
import com.core.ui.uiElements.ArrowRightIconButton
import com.core.ui.uiElements.ErrorDisplay
import com.core.ui.uiElements.ShimmerDisplay

@Composable
fun ItemUI(item: AudioDataItem) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .clip(AppTheme.shapes.smallCornersDp)
            .background(AppTheme.colors.baseBlueLight)
    ) {
        Box(
            modifier = Modifier
                .padding(20.dp)
                .size(120.dp)
        ) {
            SubcomposeAsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(AppTheme.shapes.smallestCornersDp),
                model = item.imageRes,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                loading = {
                    ShimmerDisplay(background = AppTheme.colors.baseGray)
                },
                error = {
                    ErrorDisplay(tintColor = AppTheme.colors.basePeachy)
                }
            )

            if (item.isFavourite)
                Icon(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset(x = 8.dp, y = 4.dp)
                        .width(24.dp),
                    imageVector = MyIconPack.Flame,
                    contentDescription = null,
                    tint = AppTheme.colors.lightRed
                )
        }

        Row(
            modifier = Modifier
                .padding(horizontal = 14.dp)
                .padding(bottom = 20.dp)
                .width(120.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = item.name,
                color = AppTheme.colors.white,
                style = AppTheme.typography.bodySmall,
                maxLines = 2, //todo сделать все одной высоты
                overflow = TextOverflow.Ellipsis
            )

            ArrowRightIconButton(onClick = {})
        }
    }
}