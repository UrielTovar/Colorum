package com.colorum.app.pigments.data.dataSource

import com.colorum.app.pigments.domain.entity.Pigment
import kotlinx.coroutines.flow.Flow

internal interface PigmentRemoteDataSource {
	
	suspend fun fetchPigments(): Flow<List<Pigment>>
	
}