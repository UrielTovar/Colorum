package com.tovar.colorum.datastore.domain.useCase.getPreference

import androidx.datastore.preferences.core.Preferences
import com.tovar.colorum.datastore.domain.DataStoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPreferenceUseCase @Inject constructor(
	private val repository: DataStoreRepository
) {
	
	suspend operator fun <T> invoke(key: Preferences.Key<T>, defaultValue: T): Flow<T> =
		repository.getPreference(key = key, defaultValue = defaultValue).flowOn(Dispatchers.IO)
	
}