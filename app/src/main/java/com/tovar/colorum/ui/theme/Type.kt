package com.tovar.colorum.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tovar.colorum.R

val fonts = FontFamily(
	Font(resId = R.font.avenir_regular, weight = FontWeight.Normal),
	Font(resId = R.font.avenir_medium, weight = FontWeight.Medium),
	Font(resId = R.font.avenir_bold, weight = FontWeight.SemiBold)
)

val Typography = Typography(
	body1 = TextStyle(
		fontFamily = fonts,
		fontSize = 14.sp
	),
	subtitle1 = TextStyle(
		fontFamily = fonts,
		fontWeight = FontWeight.Medium
	),
	h6 = TextStyle(
		fontFamily = fonts,
		fontWeight = FontWeight.SemiBold
	)
)