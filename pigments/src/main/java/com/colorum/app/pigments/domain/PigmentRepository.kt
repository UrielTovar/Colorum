package com.colorum.app.pigments.domain

import com.colorum.app.pigments.domain.entity.Pigment
import kotlinx.coroutines.flow.Flow

interface PigmentRepository {
	
	suspend fun fetchPigments(): Flow<List<Pigment>>
	
}