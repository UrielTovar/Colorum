package com.colorum.app.presentation.overview

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.hilt.navigation.compose.hiltViewModel
import com.colorum.app.R
import com.colorum.app.presentation.base.components.BackgroundGradient

@Composable
fun OverviewScreen(
	viewModel: OverviewViewModel = hiltViewModel()
) {
	val backgroundColor = viewModel.backgroundColor.collectAsState()
	
	BackgroundGradient(
		secondaryColor = Color(backgroundColor.value)
	) {
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
						IconButton(onClick = {
							viewModel.getPreference(
								longPreferencesKey("background_color"),
								4292446245
							)
						}) {
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