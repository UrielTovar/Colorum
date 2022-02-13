package com.colorum.app.colors.data

import com.colorum.app.colors.data.dataSource.ColorRemoteDataSource
import com.colorum.app.colors.domain.ColorRepository
import com.colorum.app.colors.domain.entity.Color
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class ColorRepositoryImpl @Inject constructor(
	private val remoteDataSource: ColorRemoteDataSource
) : ColorRepository {
	
	override suspend fun fetchColors(): Flow<List<Color>> =
		remoteDataSource.fetchColors()
	
}