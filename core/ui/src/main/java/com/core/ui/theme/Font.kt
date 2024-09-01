package com.core.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.core.ui.R

val mainFont = FontFamily(
    Font(R.font.main)
)

val montserratFont = FontFamily(
    Font(resId = R.font.montserrat_regular, weight = FontWeight.Normal),
    Font(resId = R.font.montserrat_medium, weight = FontWeight.Medium),
)