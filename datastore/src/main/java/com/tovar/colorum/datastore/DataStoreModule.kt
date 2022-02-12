package com.tovar.colorum.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.tovar.colorum.datastore.data.DataStoreRepositoryImpl
import com.tovar.colorum.datastore.data.dataSource.DataStoreLocalDataSource
import com.tovar.colorum.datastore.data.dataSource.local.DataStoreLocalDataSourceImpl
import com.tovar.colorum.datastore.domain.DataStoreRepository
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