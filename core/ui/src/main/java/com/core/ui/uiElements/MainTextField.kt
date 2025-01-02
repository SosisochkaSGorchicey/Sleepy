package com.core.ui.uiElements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.core.ui.theme.AppTheme

@Composable
fun MainTextField(
    currentText: String,
    placeholderText: String,
    onValueChange: (String) -> Unit,
    singleLine: Boolean = true,
    lines: Int = 1,
) {
    SelectionContainer {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = currentText,
            onValueChange = onValueChange,
            shape = AppTheme.shapes.smallestCornersDp,
            singleLine = singleLine,
            minLines = lines,
            maxLines = lines,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = AppTheme.colors.baseBlue.copy(alpha = .6f),
                unfocusedBorderColor = AppTheme.colors.baseBlueLight,
                focusedContainerColor = AppTheme.colors.white.copy(alpha = .3f),
                unfocusedContainerColor = AppTheme.colors.white.copy(alpha = .2f),
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
            }
        )
    }
}