package com.colorum.app.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.colorum.app.presentation.common.extension.dataStorePreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
	
	@Singleton
	@Provides
	fun providePreferences(@ApplicationContext context: Context): DataStore<Preferences> =
		context.dataStorePreferences
	
}