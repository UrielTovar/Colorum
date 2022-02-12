package com.tovar.colorum.presentation.overview

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tovar.colorum.datastore.domain.useCase.getPreference.GetPreferenceUseCase
import com.tovar.colorum.datastore.domain.useCase.putPreference.PutPreferenceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import logcat.logcat
import javax.inject.Inject

@HiltViewModel
class OverviewViewModel @Inject constructor(
	private val putPreferenceUseCase: PutPreferenceUseCase,
	private val getPreferenceUseCase: GetPreferenceUseCase
): ViewModel() {
	
	private val _backgroundColor = MutableStateFlow(4280655577)
	val backgroundColor: StateFlow<Long> get() = _backgroundColor
	
	init {
		putPreference(key = longPreferencesKey("background_color"), value = backgroundColor.value)
	}
	
	private fun <T> putPreference(key: Preferences.Key<T>, value: T?) = viewModelScope.launch {
		putPreferenceUseCase.invoke(
			key, value
		).catch {
			logcat { "PutPreference 😭 : $it" }
		}.collect {
			logcat { "PutPreference 😁 : $it" }
		}
	}
	
	fun <T> getPreference(key: Preferences.Key<T>, defaultValue: T) = viewModelScope.launch {
		getPreferenceUseCase.invoke(
			key, defaultValue
		).catch {
			logcat { "GetPreference 😭 : $it" }
		}.collect {
			_backgroundColor.value = it as Long
			logcat { "GetPreference 😁 : $it" }
		}
	}

}