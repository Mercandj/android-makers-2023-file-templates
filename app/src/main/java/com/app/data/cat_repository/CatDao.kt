package com.app.data.cat_repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import com.app.domain.cat.CatDTO

@Dao
interface CatDao {

    @Insert
    suspend fun addCat(catDTO: CatDTO)

    @Query("SELECT*FROM $CAT_TABLE")
    fun getCats(): Flow<List<CatDTO>>

    @Query("SELECT*FROM $CAT_TABLE WHERE $CAT_TABLE.id = :id ")
    suspend fun getCatForId(id: String): CatDTO

    @Update
    suspend fun updateCat(catDTO: CatDTO)

    @Delete
    suspend fun deleteCat(catDTO: CatDTO)

    companion object {
        const val CAT_TABLE = "cat_table"
    }
}
