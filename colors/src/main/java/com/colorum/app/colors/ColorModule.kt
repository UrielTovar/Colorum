package com.colorum.app.colors

import com.colorum.app.colors.data.ColorRepositoryImpl
import com.colorum.app.colors.data.dataSource.ColorRemoteDataSource
import com.colorum.app.colors.data.dataSource.remote.ColorRemoteDataSourceImpl
import com.colorum.app.colors.domain.ColorRepository
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ColorModule {
	
	@Singleton
	@Provides
	fun provideRepository(
		remoteDataSource: ColorRemoteDataSource
	): ColorRepository = ColorRepositoryImpl(remoteDataSource = remoteDataSource)
	
	@Singleton
	@Provides
	fun provideRemoteDataSource(
		firestore: FirebaseFirestore
	): ColorRemoteDataSource = ColorRemoteDataSourceImpl(firestore = firestore)
	
}