package com.colorum.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.colorum.app.presentation.overview.OverviewScreen
import com.colorum.app.presentation.ui.theme.ColorumTheme
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