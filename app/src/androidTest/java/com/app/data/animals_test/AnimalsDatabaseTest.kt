package com.app.animals_test

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.app.data.animals.AnimalsRoomDatabase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import com.app.data.dog_repository.DogDao
import com.app.domain.dog.DogDTO
import com.app.data.cat_repository.CatDao
import com.app.domain.cat.CatDTO

@RunWith(AndroidJUnit4::class)
@SmallTest
class AnimalsDatabaseTest {

    private lateinit var database: AnimalsRoomDatabase
    private lateinit var dogDao: DogDao
    private lateinit var catDao: CatDao

    @Before
    fun setupDatabase() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AnimalsRoomDatabase::class.java
        ).allowMainThreadQueries().build()

        dogDao = database.dogDao()
        catDao = database.catDao()
    }

    @After
    fun closeDatabase() {
        database.close()
    }

    @Test
    fun implementNeededTest() {
        TODO("Please, implement test for the Database.")
    }

}