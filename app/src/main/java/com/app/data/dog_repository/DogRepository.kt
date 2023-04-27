package com.app.data.dog_repository

import kotlinx.coroutines.flow.Flow
import com.app.domain.dog.Dog

interface DogRepository {

    suspend fun addDog(dog: Dog)

    fun getDogs(): Flow<List<Dog>>

    suspend fun getDogForId(id: String): Dog

    suspend fun updateDog(dog: Dog)

    suspend fun deleteDog(dog: Dog)
}
