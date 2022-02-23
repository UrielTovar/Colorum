package com.colorum.app.presentation.common.extension

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

private const val PREFERENCES_NAME = "user_preferences"

val Context.dataStorePreferences: DataStore<Preferences>
	by preferencesDataStore(PREFERENCES_NAME)