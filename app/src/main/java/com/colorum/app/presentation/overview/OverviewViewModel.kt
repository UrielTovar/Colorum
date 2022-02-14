package com.colorum.app.presentation.overview

import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.colorum.app.datastore.domain.useCase.getPreference.GetPreferenceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import logcat.logcat
import javax.inject.Inject

@HiltViewModel
class OverviewViewModel @Inject constructor(
	private val getPreferenceUseCase: GetPreferenceUseCase
) : ViewModel() {
	
	private val _backgroundColor = MutableStateFlow(4280655577)
	val backgroundColor: StateFlow<Long> get() = _backgroundColor
	
	fun <T> getPreference(key: Preferences.Key<T>, defaultValue: T) = viewModelScope.launch {
		getPreferenceUseCase.invoke(key, defaultValue)
			.catch {
				logcat { "GetPreference 😭 : $it" }
			}
			.collect {
				_backgroundColor.value = it as Long
				logcat { "GetPreference 😁 : $it" }
			}
	}
	
}