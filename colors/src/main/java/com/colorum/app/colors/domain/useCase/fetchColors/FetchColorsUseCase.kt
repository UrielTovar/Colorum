package com.colorum.app.colors.domain.useCase.fetchColors

import com.colorum.app.colors.domain.ColorRepository
import com.colorum.app.colors.domain.entity.Color
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FetchColorsUseCase @Inject constructor(
	private val repository: ColorRepository
) {
	
	suspend operator fun invoke(): Flow<List<Color>> =
		repository.fetchColors().flowOn(Dispatchers.IO)
	
}