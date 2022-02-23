package com.colorum.app.datastore.data.dataSource.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.colorum.app.datastore.data.dataSource.DataStoreLocalDataSource
import com.colorum.app.datastore.data.dataSource.local.preferences.extensions.get
import com.colorum.app.datastore.data.dataSource.local.preferences.extensions.put
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class DataStoreLocalDataSourceImpl @Inject constructor(
	private val preferences: DataStore<Preferences>
) : DataStoreLocalDataSource {
	
	override suspend fun <T> putPreference(key: Preferences.Key<T>, value: T?): Flow<Unit> =
		preferences.put(key = key, value = value)
	
	override suspend fun <T> getPreference(key: Preferences.Key<T>, defaultValue: T): Flow<T> =
		preferences.get(key = key, defaultValue = defaultValue)
	
}