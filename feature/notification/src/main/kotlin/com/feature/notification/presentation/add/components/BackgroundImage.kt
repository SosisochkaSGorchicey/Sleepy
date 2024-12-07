package com.feature.notification.presentation.add.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.core.ui.R

@Composable
fun BoxScope.BackgroundImage() {
    Image(
        modifier = Modifier
            .align(Alignment.TopEnd)
            .fillMaxWidth(.45f)
            .offset(x = 50.dp, y = (-50).dp),
        painter = painterResource(R.drawable.flower_light_face),
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}