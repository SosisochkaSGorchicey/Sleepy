package com.core.ui.uiElements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.valentinilk.shimmer.shimmer

@Composable
fun ShimmerDisplay(
    background: Color
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .shimmer()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(background)
        )
    }
}