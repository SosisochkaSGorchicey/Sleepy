package com.feature.initial.splash.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.core.ui.R

@Composable
fun BackgroundUI() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background( //todo
                brush = Brush.linearGradient(
                    listOf(
                        Color(0xFF3873B8),
                        Color(0xFFCACDD3)
                    )
                )
            )
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight(.75f)
                .align(Alignment.BottomStart),
            painter = painterResource(id = R.drawable.light_form),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.BottomStart
        )

        Image(
            modifier = Modifier
                .fillMaxHeight(.4f)
                .align(Alignment.BottomStart),
            painter = painterResource(id = R.drawable.dark_form),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.TopEnd
        )

        Image(
            modifier = Modifier
                .padding(40.dp)
                .fillMaxWidth(.45f)
                .align(Alignment.BottomEnd),
            painter = painterResource(id = R.drawable.flower_light_face),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )

        Image(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(.50f)
                .align(Alignment.CenterStart),
            painter = painterResource(id = R.drawable.flower_dark_face),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
    }
}