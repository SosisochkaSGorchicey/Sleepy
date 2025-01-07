package com.core.ui.animations

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable

@Composable
fun <T> defaultSpring(): AnimationSpec<T> = spring(stiffness = Spring.StiffnessLow)

val fadeIn @Composable get() = fadeIn(animationSpec = spring(stiffness = Spring.StiffnessLow))