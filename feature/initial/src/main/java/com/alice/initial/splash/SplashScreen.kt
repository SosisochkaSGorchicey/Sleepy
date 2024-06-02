package com.alice.initial.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun SplashScreen() {
    val infiniteTransition = rememberInfiniteTransition(label = "infiniteTransition")

    // Анимация подъема луны
    val moonOffsetY by infiniteTransition.animateFloat(
        initialValue = 600f,
        targetValue = 100f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    // Анимация размера луны
    val moonSize by infiniteTransition.animateFloat(
        initialValue = 50f,
        targetValue = 80f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    // Анимация мерцания звезд
    val starAlphas = remember { List(100) { Animatable(Random.nextFloat()) } }
    LaunchedEffect(starAlphas) {
        starAlphas.forEach { star ->
            launch {
                while (true) {
                    star.animateTo(
                        targetValue = Random.nextFloat(),
                        animationSpec = tween(durationMillis = Random.nextInt(1000, 3000))
                    )
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = androidx.compose.ui.graphics.Brush.verticalGradient(
                    listOf(Color(0xFF000080), Color(0xFF000033))
                )
            )
    ) {
        // Рисование звезд
        Canvas(modifier = Modifier.fillMaxSize()) {
            starAlphas.forEachIndexed { index, animatable ->
                drawCircle(
                    color = Color.White,
                    radius = 2f,
                    center = androidx.compose.ui.geometry.Offset(
                        x = Random.nextFloat() * size.width,
                        y = Random.nextFloat() * size.height
                    ),
                    alpha = animatable.value
                )
            }
        }

        // Рисование луны
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(
                color = Color(0xFFFFD700),
                radius = moonSize,
                center = androidx.compose.ui.geometry.Offset(size.width / 2, moonOffsetY)
            )
        }
    }
}