package com.tovar.colorum

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tovar.colorum.ui.theme.ColorumTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ColorumTheme {
				Surface(color = MaterialTheme.colors.background) {
				
				}
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	ColorumTheme {
	
	}
}