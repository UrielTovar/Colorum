package com.colorum.app.datastore.data.dataSource.local.preferences.extensions

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.map

internal suspend fun <T> DataStore<Preferences>.put(
	key: Preferences.Key<T>,
	value: T?
): Flow<Unit> = callbackFlow {
	edit { _preference ->
		value?.let {
			_preference[key] = it
			trySend(Unit)
		} ?: run {
			close(NullPointerException())
		}
	}
	awaitClose { }
}

internal fun <T> DataStore<Preferences>.get(
	key: Preferences.Key<T>,
	defaultValue: T
): Flow<T> = data.map {
	it[key] ?: defaultValue
}