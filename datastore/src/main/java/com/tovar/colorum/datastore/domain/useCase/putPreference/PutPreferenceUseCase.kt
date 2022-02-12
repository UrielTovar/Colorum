package com.tovar.colorum.datastore.domain.useCase.putPreference

import androidx.datastore.preferences.core.Preferences
import com.tovar.colorum.datastore.domain.DataStoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

class PutPreferenceUseCase @Inject constructor(
	private val repository: DataStoreRepository
) {
	
	suspend operator fun <T> invoke(key: Preferences.Key<T>, value: T?): Flow<Unit> =
		repository.putPreference(key = key, value = value).flowOn(Dispatchers.IO)
	
}