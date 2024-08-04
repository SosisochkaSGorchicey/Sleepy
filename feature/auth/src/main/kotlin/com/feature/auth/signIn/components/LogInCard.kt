package com.feature.auth.signIn.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.alice.ui.theme.AppTheme
import com.core.ui.R

@Composable
fun LogInCard(bottomSheetModifier: Modifier) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(AppTheme.shapes.topForm)
                .background(AppTheme.colors.lightPeachy)
                .verticalScroll(rememberScrollState())
                .then(bottomSheetModifier)
                .padding(horizontal = 24.dp, vertical = 32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            LogInHeader()
            Text(text = ",mkjnhg")
            Text(text = ",mkjnhg")
            Text(text = ",mkjnhg")
            Text(text = ",mkjnhg")
            Text(text = ",mkjnhg")
            Text(text = ",mkjnhg")
            Text(text = ",mkjnhg")
            Text(text = ",mkjnhg")
        }

        LogInImage()
    }
}

@Composable
private fun BoxScope.LogInImage() {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    Image(
        modifier = Modifier
            .offset(y = -(screenWidth / 5))
            .align(Alignment.TopEnd)
            .width(screenWidth / 2)
            .rotate(25f),
        painter = painterResource(id = R.drawable.flower_dark_face),
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}

@Composable
private fun LogInHeader() {
    Text(
        modifier = Modifier.fillMaxWidth(.6f),
        text = stringResource(id = R.string.log_in_header),
        color = AppTheme.colors.baseBlue,
        style = AppTheme.typography.headlineMedium
    )
}