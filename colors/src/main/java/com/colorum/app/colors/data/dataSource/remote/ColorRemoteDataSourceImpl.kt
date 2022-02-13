package com.colorum.app.colors.data.dataSource.remote

import com.colorum.app.colors.data.dataSource.ColorRemoteDataSource
import com.colorum.app.colors.domain.entity.Color
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

internal class ColorRemoteDataSourceImpl @Inject constructor(
	private val firestore: FirebaseFirestore
) : ColorRemoteDataSource {
	
	override suspend fun fetchColors(): Flow<List<Color>> = callbackFlow {
		try {
			val documents = firestore
				.collection(COLOR_COLLECTION_KEY)
				.get()
				.await()
			
			val colors = documents.map { getColorBy(document = it) }
			
			trySend(colors)
		} catch (exception: Exception) {
			close(exception)
		}
		awaitClose { }
	}
	
	private fun getColorBy(document: DocumentSnapshot): Color =
		Color(
			id = document.id,
			name = document.get(NAME, String::class.java),
			value = document.get(VALUE, Long::class.java)
		)
	
	private companion object {
		const val COLOR_COLLECTION_KEY = "color"
		const val NAME: String = "name"
		const val VALUE: String = "value"
	}
	
}