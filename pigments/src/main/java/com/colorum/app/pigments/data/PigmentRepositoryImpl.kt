package com.colorum.app.pigments.data

import com.colorum.app.pigments.data.dataSource.PigmentRemoteDataSource
import com.colorum.app.pigments.domain.PigmentRepository
import com.colorum.app.pigments.domain.entity.Pigment
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class PigmentRepositoryImpl @Inject constructor(
	private val remoteDataSource: PigmentRemoteDataSource
) : PigmentRepository {
	
	override suspend fun fetchPigments(): Flow<List<Pigment>> =
		remoteDataSource.fetchPigments()
	
}