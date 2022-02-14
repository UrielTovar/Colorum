package com.colorum.app.presentation.palette

import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.colorum.app.datastore.domain.useCase.putPreference.PutPreferenceUseCase
import com.colorum.app.pigments.domain.entity.Pigment
import com.colorum.app.pigments.domain.useCase.fetchPigments.FetchPigmentsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class PaletteViewModel @Inject constructor(
	private val fetchPigmentsUseCase: FetchPigmentsUseCase,
	private val putPreferenceUseCase: PutPreferenceUseCase
) : ViewModel() {
	
	private val _pigments = MutableStateFlow<List<Pigment>>(emptyList())
	val pigments: StateFlow<List<Pigment>> get() = _pigments
	
	private val _isSuccessfulAdded = MutableStateFlow(false)
	val isSuccessfulAdded: StateFlow<Boolean> get() = _isSuccessfulAdded
	
	private val _error = MutableStateFlow<Throwable?>(null)
	val error: StateFlow<Throwable?> get() = _error
	
	init {
		fetchPigments()
	}
	
	private fun fetchPigments() = viewModelScope.launch {
		fetchPigmentsUseCase.invoke()
			.catch {
				_error.value = it
			}.collectLatest {
				_pigments.value = it
			}
	}
	
	fun <T> putPreference(key: Preferences.Key<T>, value: T?) = viewModelScope.launch {
		putPreferenceUseCase.invoke(
			key, value
		).catch {
			_error.value = it
		}.collect {
			_isSuccessfulAdded.value = true
		}
	}
	
}