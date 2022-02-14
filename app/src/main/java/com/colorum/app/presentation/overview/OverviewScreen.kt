package com.colorum.app.presentation.overview

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.colorum.app.R
import com.colorum.app.presentation.base.components.BackgroundGradient

@Composable
fun OverviewScreen(
	viewModel: OverviewViewModel = hiltViewModel(),
	navigationController: NavController
) {
	val backgroundColor by viewModel.backgroundColor.collectAsState()
	
	BackgroundGradient(
		secondaryColor = Color(backgroundColor)
	) {
		Scaffold(
			topBar = {
				TopAppBar(
					title = {
						Text(
							text = stringResource(R.string.app_name),
							style = MaterialTheme.typography.h6,
							fontSize = 16.sp
						)
					},
					backgroundColor = Color.Transparent,
					elevation = 0.dp,
					actions = {
						IconButton(
							onClick = {
								navigationController.navigate(route = "palette")
							}
						) {
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