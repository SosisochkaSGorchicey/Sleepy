package com.feature.initial.splash.content

import androidx.compose.animation.core.EaseOutBounce
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun getScaleTextAnimation(): Float {
    val infiniteTransition = rememberInfiniteTransition(label = "infinite")

    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1250, easing = EaseOutBounce),
            repeatMode = RepeatMode.Reverse
        ),
        label = "color"
    )

    return scale
}

@Composable
fun getRotateAnimationBig(): Float {
    val infiniteTransition = rememberInfiniteTransition(label = "infinite")

    val rotate by infiniteTransition.animateFloat(
        initialValue = 30f,
        targetValue = -30f,
        animationSpec = infiniteRepeatable(
            animation = tween(1250, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "color"
    )

    return rotate
}

@Composable
fun getRotateAnimationSmall(): Float {
    val infiniteTransition = rememberInfiniteTransition(label = "infinite")

    val rotate by infiniteTransition.animateFloat(
        initialValue = -30f,
        targetValue = 30f,
        animationSpec = infiniteRepeatable(
            animation = tween(1250, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "color"
    )

    return rotate
}

@Composable
fun BoxScope.smallMovingElementModifier() = Modifier
    .padding(40.dp)
    .fillMaxWidth(.45f)
    .align(Alignment.BottomEnd)

@Composable
fun BoxScope.bigMovingElementModifier() = Modifier
    .padding(20.dp)
    .fillMaxWidth(.50f)
    .align(Alignment.CenterStart)
