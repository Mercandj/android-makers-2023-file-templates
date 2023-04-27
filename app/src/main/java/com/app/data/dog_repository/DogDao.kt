package com.app.data.dog_repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import com.app.domain.dog.DogDTO

@Dao
interface DogDao {

    @Insert
    suspend fun addDog(dogDTO: DogDTO)

    @Query("SELECT*FROM $DOG_TABLE")
    fun getDogs(): Flow<List<DogDTO>>

    @Query("SELECT*FROM $DOG_TABLE WHERE $DOG_TABLE.id = :id ")
    suspend fun getDogForId(id: String): DogDTO

    @Update
    suspend fun updateDog(dogDTO: DogDTO)

    @Delete
    suspend fun deleteDog(dogDTO: DogDTO)

    companion object {
        const val DOG_TABLE = "dog_table"
    }
}
