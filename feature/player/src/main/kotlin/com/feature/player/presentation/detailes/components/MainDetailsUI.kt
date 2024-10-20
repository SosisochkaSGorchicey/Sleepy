package com.feature.player.presentation.detailes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.core.ui.R
import com.core.ui.modifiers.baseRoundedBorder
import com.core.ui.theme.AppTheme

@Composable
fun MainDetailsUI() {
    Image(
        modifier = Modifier
            .fillMaxWidth(.7f)
            .aspectRatio(1f)
            .clip(AppTheme.shapes.smallCornersDp),
        painter = painterResource(R.drawable.test_image), //todo
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState()),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally)
    ) {
        ActionItem(onClick = {})
        DescriptionItem(text = "35 min") //todo
        DescriptionItem(text = "Relaxing") //todo
    }
}

@Composable
private fun DescriptionItem(text: String) {
    Text(
        modifier = Modifier
            .clip(AppTheme.shapes.rounded)
            .background(AppTheme.colors.milkyWhite)
            .baseRoundedBorder(AppTheme.colors.basePeachy)
            .padding(10.dp),
        text = text,
        color = AppTheme.colors.baseBlue,
        style = AppTheme.typography.bodySmall
    )
}

@Composable
private fun ActionItem(onClick: () -> Unit) {
    val isFavourite = remember { mutableStateOf(false) } //todo

    Box(
        modifier = Modifier
            .clip(AppTheme.shapes.rounded)
            .aspectRatio(1f)
            .clickable(onClick = { isFavourite.value = !isFavourite.value }),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .padding(8.dp)
                .size(36.dp),
            imageVector = if (isFavourite.value) Icons.Default.Favorite
            else Icons.Default.FavoriteBorder,
            contentDescription = null,
            tint = AppTheme.colors.milkyWhite
        )
    }
}