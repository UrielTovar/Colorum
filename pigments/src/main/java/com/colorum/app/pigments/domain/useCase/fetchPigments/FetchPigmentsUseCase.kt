package com.colorum.app.pigments.domain.useCase.fetchPigments

import com.colorum.app.pigments.domain.PigmentRepository
import com.colorum.app.pigments.domain.entity.Pigment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchPigmentsUseCase @Inject constructor(
	private val repository: PigmentRepository
) {
	
	suspend operator fun invoke(): Flow<List<Pigment>> =
		repository.fetchPigments().flowOn(Dispatchers.IO)
	
}