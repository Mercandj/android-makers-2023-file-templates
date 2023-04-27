package com.app.data.cat_repository

import kotlinx.coroutines.flow.Flow
import com.app.domain.cat.Cat

interface CatRepository {

    suspend fun addCat(cat: Cat)

    fun getCats(): Flow<List<Cat>>

    suspend fun getCatForId(id: String): Cat

    suspend fun updateCat(cat: Cat)

    suspend fun deleteCat(cat: Cat)
}
