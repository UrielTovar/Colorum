package com.colorum.app.colors.domain

import com.colorum.app.colors.domain.entity.Color
import kotlinx.coroutines.flow.Flow

interface ColorRepository {
	
	suspend fun fetchColors(): Flow<List<Color>>
	
}