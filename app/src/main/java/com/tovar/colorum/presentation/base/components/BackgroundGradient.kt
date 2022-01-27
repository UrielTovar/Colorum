package com.tovar.colorum.presentation.base.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.tovar.colorum.presentation.ui.theme.charade

@Composable
fun BackgroundGradient(secondaryColor: Color, content: @Composable () -> Unit) {
	Surface(
		color = Color.Black.copy(0.0F),
		modifier = Modifier
			.fillMaxSize()
			.background(brush = Brush.verticalGradient(colors = listOf(charade, secondaryColor)))
	) {
		content()
	}
}