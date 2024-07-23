package com.feature.initial.splash.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alice.ui.theme.mainFont
import com.core.ui.R


@Composable
fun SplashScreenContent(
    modifier: Modifier
) {
    BackgroundUI()

    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Text(
            modifier = Modifier.padding(top = 32.dp),
            text = stringResource(id = R.string.sleepy),
            fontFamily = mainFont,
            fontSize = 72.sp,
            color = Color(0xFFF7EBE9) //todo all
        )
    }
}