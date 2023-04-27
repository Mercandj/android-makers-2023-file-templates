package com.app.data.dog_repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.app.domain.dog.Dog

class DogRepositoryImpl(
    private val dogDao: DogDao
) : DogRepository {

    override suspend fun addDog(dog: Dog) {
        dogDao.addDog(dog.toDTO())
    }

    override fun getDogs(): Flow<List<Dog>> {
        return dogDao.getDogs().map { dogList ->
            dogList.map { dogDTO ->
                dogDTO.toModel()
            }
        }
    }

    override suspend fun getDogForId(id: String): Dog {
        return dogDao.getDogForId(id).toModel()
    }

    override suspend fun updateDog(dog: Dog) {
        dogDao.updateDog(dog.toDTO())
    }

    override suspend fun deleteDog(dog: Dog) {
        dogDao.deleteDog(dog.toDTO())
    }
}
