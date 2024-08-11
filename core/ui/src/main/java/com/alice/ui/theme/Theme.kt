package com.alice.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme() { ProvideAppThemeDependencies(content = content) }
}

@Composable
private fun ProvideAppThemeDependencies(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalAppColors provides AppColors(),
        LocalAppTypography provides AppTypography(),
        LocalAppShapes provides AppShapes(),
        content = content
    )
}

object AppTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current

    val typography: AppTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalAppTypography.current

    val shapes: AppShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalAppShapes.current
}