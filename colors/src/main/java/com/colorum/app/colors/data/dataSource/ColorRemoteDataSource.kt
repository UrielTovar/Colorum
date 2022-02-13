package com.colorum.app.colors.data.dataSource

import com.colorum.app.colors.domain.entity.Color
import kotlinx.coroutines.flow.Flow

internal interface ColorRemoteDataSource {
	
	suspend fun fetchColors(): Flow<List<Color>>
	
}