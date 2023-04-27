package com.app.data.cat_repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.app.domain.cat.Cat

class CatRepositoryImpl(
    private val catDao: CatDao
) : CatRepository {

    override suspend fun addCat(cat: Cat) {
        catDao.addCat(cat.toDTO())
    }

    override fun getCats(): Flow<List<Cat>> {
        return catDao.getCats().map { catList ->
            catList.map { catDTO ->
                catDTO.toModel()
            }
        }
    }

    override suspend fun getCatForId(id: String): Cat {
        return catDao.getCatForId(id).toModel()
    }

    override suspend fun updateCat(cat: Cat) {
        catDao.updateCat(cat.toDTO())
    }

    override suspend fun deleteCat(cat: Cat) {
        catDao.deleteCat(cat.toDTO())
    }
}
