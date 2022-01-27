package com.tovar.colorum.presentation.overview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.tovar.colorum.presentation.base.components.BackgroundGradient
import com.tovar.colorum.presentation.ui.theme.ColorumTheme

class OverviewActivity : ComponentActivity() {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ColorumTheme {
				Surface(color = MaterialTheme.colors.background) {
					// TODO: Use secondary color value stored in datastore
					BackgroundGradient(secondaryColor = Color.Blue) {
					
					}
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
			BackgroundGradient(secondaryColor = Color.Blue) {
				
			}
		}
	}
}