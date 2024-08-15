package com.core.ui.uiElements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import com.core.ui.theme.AppTheme

@Composable
fun RoundedTextField(
    modifier: Modifier = Modifier.fillMaxWidth(),
    currentText: String,
    placeholderText: String,
    onValueChange: (String) -> Unit,
    errorTextRes: Int? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = errorTextRes?.let { stringResource(id = it) } ?: "",
            style = AppTheme.typography.bodySuperSmall,
            color = AppTheme.colors.baseRed
        )

        SelectionContainer {
            OutlinedTextField(
                modifier = modifier,
                value = currentText,
                onValueChange = onValueChange,
                shape = AppTheme.shapes.rounded,
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = AppTheme.colors.baseBlue.copy(alpha = .6f),
                    unfocusedBorderColor = AppTheme.colors.basePeachy,
                    focusedContainerColor = AppTheme.colors.milkyWhite,
                    unfocusedContainerColor = AppTheme.colors.milkyWhite,
                    focusedTextColor = AppTheme.colors.baseBlue,
                    unfocusedTextColor = AppTheme.colors.baseBlue.copy(alpha = .6f),
                    focusedPlaceholderColor = AppTheme.colors.baseBlue.copy(alpha = .6f),
                    unfocusedPlaceholderColor = AppTheme.colors.baseBlue.copy(alpha = .6f),
                    cursorColor = AppTheme.colors.baseBlue,
                    selectionColors = TextSelectionColors(
                        handleColor = AppTheme.colors.baseBlue,
                        backgroundColor = AppTheme.colors.baseBlue.copy(alpha = .3f)
                    ),
                    errorTextColor = AppTheme.colors.baseRed,
                    errorContainerColor = AppTheme.colors.milkyWhite,
                    errorBorderColor = AppTheme.colors.baseRed
                ),
                textStyle = AppTheme.typography.bodyMedium,
                placeholder = {
                    Text(
                        text = placeholderText,
                        style = AppTheme.typography.bodySmall
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                visualTransformation = visualTransformation,
                isError = errorTextRes != null
            )
        }
    }
}