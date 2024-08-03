package com.alice.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val ColorScheme.AppColors: AppColors
    get() = AppColors()

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