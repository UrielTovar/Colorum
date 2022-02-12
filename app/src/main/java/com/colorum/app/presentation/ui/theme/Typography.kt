package com.colorum.app.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.colorum.app.R

private val regular = Font(R.font.avenir_regular, FontWeight.Normal)
private val medium = Font(R.font.avenir_medium, FontWeight.Medium)
private val semibold = Font(R.font.avenir_bold, FontWeight.SemiBold)

val colorumFontFamily = FontFamily(regular, medium, semibold)

val colorumTypography = Typography(
	body1 = TextStyle(
		fontFamily = colorumFontFamily,
		fontSize = 14.sp
	),
	subtitle1 = TextStyle(
		fontFamily = colorumFontFamily,
		fontWeight = FontWeight.Medium
	),
	h6 = TextStyle(
		fontFamily = colorumFontFamily,
		fontWeight = FontWeight.SemiBold,
		fontSize = 16.sp
	)
)