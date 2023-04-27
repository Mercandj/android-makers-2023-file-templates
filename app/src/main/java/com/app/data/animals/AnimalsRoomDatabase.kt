package com.app.data.animals

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.data.dog_repository.DogDao
import com.app.domain.dog.DogDTO
import com.app.data.cat_repository.CatDao
import com.app.domain.cat.CatDTO

@Database(
    entities = [DogDTO::class, CatDTO::class],
    version = 1,
    exportSchema = false
)
abstract class AnimalsRoomDatabase : RoomDatabase() {

    abstract fun dogDao(): DogDao
    abstract fun catDao(): CatDao

    companion object {

        @Volatile
        private var instance: AnimalsRoomDatabase? = null

        fun getAnimalsRoomDatabase(context: Context): AnimalsRoomDatabase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context)
                    .also { instance = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AnimalsRoomDatabase::class.java, "animals_db")
                .fallbackToDestructiveMigration()
                .build()
    }
}
