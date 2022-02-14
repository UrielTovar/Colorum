package com.colorum.app.pigments.data.dataSource.remote

import com.colorum.app.pigments.data.dataSource.PigmentRemoteDataSource
import com.colorum.app.pigments.domain.entity.Pigment
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

internal class PigmentRemoteDataSourceImpl @Inject constructor(
	private val firestore: FirebaseFirestore
) : PigmentRemoteDataSource {
	
	override suspend fun fetchPigments(): Flow<List<Pigment>> = callbackFlow {
		try {
			val documents = firestore
				.collection(PIGMENT_COLLECTION_KEY)
				.get()
				.await()
			
			val colors = documents.map { getPigmentBy(document = it) }
			
			trySend(colors)
		} catch (exception: Exception) {
			close(exception)
		}
		awaitClose { }
	}
	
	private fun getPigmentBy(document: DocumentSnapshot): Pigment =
		Pigment(
			id = document.id,
			name = document.get(NAME, String::class.java),
			value = document.get(VALUE, Long::class.java)
		)
	
	private companion object {
		const val PIGMENT_COLLECTION_KEY = "pigment"
		const val NAME: String = "name"
		const val VALUE: String = "value"
	}
	
}