package com.tovar.colorum.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.tovar.colorum.presentation.base.components.BackgroundGradient
import com.tovar.colorum.presentation.overview.OverviewScreen
import com.tovar.colorum.presentation.overview.OverviewViewModel
import com.tovar.colorum.presentation.ui.theme.ColorumTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ColorumTheme {
				Surface(color = MaterialTheme.colors.background) {
					OverviewScreen()
				}
			}
		}
	}
	
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	ColorumTheme {
		Surface(color = MaterialTheme.colors.background) {
			OverviewScreen()
		}
	}
}