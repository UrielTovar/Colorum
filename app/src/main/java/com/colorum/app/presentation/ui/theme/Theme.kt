package com.colorum.app.presentation.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val darkColorPalette = darkColors(
	primary = scarpaFlow,
	primaryVariant = charade,
	secondary = Color.White
)

@Composable
fun ColorumTheme(content: @Composable () -> Unit) {
	MaterialTheme(
		colors = darkColorPalette,
		typography = colorumTypography,
		shapes = shapes,
		content = content
	)
}