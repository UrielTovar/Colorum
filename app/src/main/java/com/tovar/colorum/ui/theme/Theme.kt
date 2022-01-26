package com.tovar.colorum.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
	primary = scarpaFlow,
	primaryVariant = charade,
	secondary = Color.White
)

@Composable
fun ColorumTheme(content: @Composable () -> Unit) {
	MaterialTheme(
		colors = DarkColorPalette,
		typography = Typography,
		shapes = Shapes,
		content = content
	)
}