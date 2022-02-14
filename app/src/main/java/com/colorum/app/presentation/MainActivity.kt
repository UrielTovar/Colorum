package com.colorum.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.colorum.app.presentation.overview.OverviewScreen
import com.colorum.app.presentation.palette.PaletteScreen
import com.colorum.app.presentation.ui.theme.ColorumTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ColorumTheme {
				Surface(color = MaterialTheme.colors.background) {
					val navigationController = rememberNavController()
					
					NavHost(navController = navigationController, startDestination = "overview") {
						composable("overview") {
							OverviewScreen(navigationController = navigationController)
						}
						composable(route = "palette") {
							PaletteScreen()
						}
					}
				}
			}
		}
	}
	
}