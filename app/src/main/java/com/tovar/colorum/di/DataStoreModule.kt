package com.tovar.colorum.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

val Context.dataStore: DataStore<Preferences> by preferencesDataStore("user_preferences")

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
	
	@Singleton
	@Provides
	fun providePreferences(@ApplicationContext context: Context): DataStore<Preferences> =
		context.dataStore
	
}