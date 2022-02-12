package com.colorum.app.datastore.data.dataSource

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

internal interface DataStoreLocalDataSource {
	
	suspend fun <T> putPreference(key: Preferences.Key<T>, value: T?): Flow<Unit>
	
	suspend fun <T> getPreference(key: Preferences.Key<T>, defaultValue: T): Flow<T>
	
}