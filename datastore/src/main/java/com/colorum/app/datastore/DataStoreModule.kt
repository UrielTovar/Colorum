package com.colorum.app.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.colorum.app.datastore.data.DataStoreRepositoryImpl
import com.colorum.app.datastore.data.dataSource.DataStoreLocalDataSource
import com.colorum.app.datastore.data.dataSource.local.DataStoreLocalDataSourceImpl
import com.colorum.app.datastore.domain.DataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DataStoreModule {
	
	@Singleton
	@Provides
	fun provideRepository(
		localDataSource: DataStoreLocalDataSource
	): DataStoreRepository = DataStoreRepositoryImpl(localDataSource = localDataSource)
	
	@Singleton
	@Provides
	fun provideLocalDataSource(
		preferences: DataStore<Preferences>
	): DataStoreLocalDataSource = DataStoreLocalDataSourceImpl(preferences = preferences)
	
}