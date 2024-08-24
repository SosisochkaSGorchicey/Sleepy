package com.core.ui.uiElements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(AppTheme.colors.baseBlueLight)
                    .padding(bottom = padding.calculateBottomPadding())
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    modifier = Modifier.size(38.dp),
                    painter = painterResource(id = R.drawable.balance),
                    contentDescription = null
                )

                Image(
                    modifier = Modifier.size(38.dp),
                    painter = painterResource(id = R.drawable.flower_dark_face_small),
                    contentDescription = null
                )

                Image(
                    modifier = Modifier.size(38.dp),
                    painter = painterResource(id = R.drawable.bell),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
private fun BottomBarItemUI() {

}