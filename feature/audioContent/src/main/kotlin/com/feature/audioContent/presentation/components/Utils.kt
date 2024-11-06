package com.feature.audioContent.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun Int.toSideModifier(list: List<Any>): Modifier = when (this) {
    0 -> Modifier.padding(start = 20.dp)
    list.lastIndex -> Modifier.padding(end = 20.dp)
    else -> Modifier
}

fun Int.toBottomModifier(list: List<Any>, modifier: Modifier): Modifier = when (this) {
    list.lastIndex -> modifier.padding(bottom = 20.dp)
    else -> Modifier
}