package com.core.ui.uiElements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.core.ui.theme.AppTheme
import com.core.ui.R

@Composable
fun MainButton(
    modifier: Modifier = Modifier.fillMaxWidth(),
    onClick: () -> Unit,
    text: String,
    addImages: Boolean = false,
    containerColor: Color = AppTheme.colors.baseBlueLight,
    contentColor: Color = AppTheme.colors.milkyWhite,
    borderColor: Color = AppTheme.colors.baseBlue
) {
    OutlinedButton(
        modifier = modifier,
        onClick = { onClick() },
        shape = AppTheme.shapes.rounded,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor,
        ),
        border = BorderStroke(
            width = 2.dp,
            color = borderColor
        )
    ) {
        if (addImages) ButtonImage()

        Text(
            text = text,
            style = AppTheme.typography.bodyMediumBold
        )
    }
}

@Composable
private fun ButtonImage() {
    Image(
        modifier = Modifier
            .padding(horizontal = 6.dp)
            .size(24.dp)
            .rotate(-25f),
        painter = painterResource(id = R.drawable.flower_dark_face),
        contentDescription = null,
        contentScale = ContentScale.Fit
    )
}