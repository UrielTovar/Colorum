package com.colorum.app.datastore.data

import androidx.datastore.preferences.core.Preferences
import com.colorum.app.datastore.data.dataSource.DataStoreLocalDataSource
import com.colorum.app.datastore.domain.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class DataStoreRepositoryImpl @Inject constructor(
	private val localDataSource: DataStoreLocalDataSource
) : DataStoreRepository {
	
	override suspend fun <T> putPreference(key: Preferences.Key<T>, value: T?): Flow<Unit> =
		localDataSource.putPreference(key = key, value = value)
	
	override suspend fun <T> getPreference(key: Preferences.Key<T>, defaultValue: T): Flow<T> =
		localDataSource.getPreference(key = key, defaultValue = defaultValue)
	
}