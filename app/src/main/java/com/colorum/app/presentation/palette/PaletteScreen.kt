package com.colorum.app.presentation.palette

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.colorum.app.R
import com.colorum.app.pigments.domain.entity.Pigment
import com.colorum.app.presentation.ui.theme.charade

@Composable
fun PaletteScreen(

) {
	Scaffold(
		backgroundColor = charade
	) {
		Column(modifier = Modifier.fillMaxWidth()) {
			Text(
				text = stringResource(id = R.string.be_picasso_title),
				style = MaterialTheme.typography.h6,
				modifier = Modifier.padding(16.dp),
				color = Color.White
			)
			LazyColumn(
				modifier = Modifier.fillMaxWidth()
			) {
				items(listOf("Green", "Red", "Blue")) { _item ->
				
				}
			}
		}
	}
}

@Composable
fun PigmentItem(
	pigment: Pigment,
	onPigmentSelect: (Pigment) -> Unit
) {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.background(Color.Transparent)
			.clickable(
				onClick = {
					onPigmentSelect(pigment)
				}
			)
	) {
		Box(
			modifier = Modifier
				.padding(10.dp)
				.size(37.dp)
				.clip(CircleShape)
				.background(Color(color = pigment.value))
		) {
			CircleShape
		}
		Text(
			text = pigment.name,
			style = MaterialTheme.typography.body1,
			modifier = Modifier
				.padding(horizontal = 16.dp)
				.align(Alignment.CenterVertically),
			color = Color.White
		)
	}
}

@Preview(showBackground = true)
@Composable
fun PaletteScreenPreview() {
	PaletteScreen()
}

@Preview(showBackground = true)
@Composable
fun ColorItemPreview() {
	PigmentItem(pigment = Pigment("", "Blue", 4292446245)) { }
}