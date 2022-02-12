package com.colorum.app.datastore.domain

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
	
	suspend fun <T> putPreference(key: Preferences.Key<T>, value: T?): Flow<Unit>
	
	suspend fun <T> getPreference(key: Preferences.Key<T>, defaultValue: T): Flow<T>
	
}