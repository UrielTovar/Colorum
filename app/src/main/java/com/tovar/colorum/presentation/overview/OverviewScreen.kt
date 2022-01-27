package com.tovar.colorum.presentation.overview

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tovar.colorum.R
import com.tovar.colorum.presentation.base.components.BackgroundGradient

@Composable
fun OverviewScreen(
	viewModel: OverviewViewModel
) {
	// TODO: Use secondary color value stored in datastore
	BackgroundGradient(secondaryColor = Color.Blue) {
		Scaffold(
			topBar = {
				TopAppBar(
					title = {
						Text(
							text = stringResource(R.string.app_name),
							style = MaterialTheme.typography.h6
						)
					},
					backgroundColor = Color.Transparent,
					elevation = 0.dp,
					actions = {
						IconButton(onClick = { /* TODO: Send to palette screen */ }) {
							Icon(
								imageVector = Icons.Outlined.Palette,
								tint = Color.White,
								contentDescription = null
							)
						}
					}
				)
			},
			backgroundColor = Color.Transparent
		) { }
	}
}