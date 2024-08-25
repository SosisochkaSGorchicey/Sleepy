package com.core.ui.uiElements

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.core.ui.R
import com.core.ui.theme.AppTheme

@Composable
fun CustomScaffoldWithBottomBar(
    content: @Composable () -> Unit
) {
    val navigator = LocalNavigator.currentOrThrow
    println("TAG: CustomScaffoldWithBottomBar ${navigator.lastItem}")

    Scaffold(
        containerColor = AppTheme.colors.transparent
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .padding(
                        top = padding.calculateTopPadding(),
                        start = padding.calculateStartPadding(layoutDirection = LayoutDirection.Ltr),
                        end = padding.calculateEndPadding(layoutDirection = LayoutDirection.Ltr)
                    )
                    .fillMaxSize()
                    .weight(1f)
            ) {
                content()
            }

            BottomBar(
                innerModifier = Modifier.padding(bottom = padding.calculateBottomPadding())
            )
        }
    }
}

@Composable
private fun BottomBar(innerModifier: Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(AppTheme.colors.baseBlue)
            .then(innerModifier)
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        BottomBarItem(
            imageRes = R.drawable.balance,
            onClick = {}
        )

        BottomBarItem(
            imageRes = R.drawable.flower_dark_face_small,
            isCurrent = true,
            onClick = {}
        )

        BottomBarItem(
            imageRes = R.drawable.bell,
            onClick = {}
        )
    }
}

@Composable
private fun BottomBarItem(
    @DrawableRes imageRes: Int,
    onClick: () -> Unit,
    isCurrent: Boolean = false
) {
    Image(
        modifier = Modifier
            .clip(AppTheme.shapes.rounded)
            .size(44.dp)
            .background(AppTheme.colors.baseBlueLight)
            .border(
                width = 3.dp,
                color = if (isCurrent) AppTheme.colors.basePeachy else AppTheme.colors.transparent,
                shape = AppTheme.shapes.rounded
            )
            .clickable(onClick = onClick)
            .padding(8.dp),
        painter = painterResource(id = imageRes),
        contentDescription = null
    )
}