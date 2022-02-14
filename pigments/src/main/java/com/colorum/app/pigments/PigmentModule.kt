package com.colorum.app.pigments

import com.colorum.app.pigments.data.PigmentRepositoryImpl
import com.colorum.app.pigments.data.dataSource.PigmentRemoteDataSource
import com.colorum.app.pigments.data.dataSource.remote.PigmentRemoteDataSourceImpl
import com.colorum.app.pigments.domain.PigmentRepository
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object PigmentModule {
	
	@Singleton
	@Provides
	fun provideRepository(
		remoteDataSource: PigmentRemoteDataSource
	): PigmentRepository = PigmentRepositoryImpl(remoteDataSource = remoteDataSource)
	
	@Singleton
	@Provides
	fun provideRemoteDataSource(
		firestore: FirebaseFirestore
	): PigmentRemoteDataSource = PigmentRemoteDataSourceImpl(firestore = firestore)
	
}