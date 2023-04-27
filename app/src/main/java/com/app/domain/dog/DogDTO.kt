package com.app.domain.dog

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.data.dog_repository.DogDao.Companion.DOG_TABLE

@Entity(tableName = DOG_TABLE)
data class DogDTO(
    @PrimaryKey(autoGenerate = false)
    val id: String
) {
    fun toModel(): Dog {
        return Dog(
            id = this.id
        )
    }
}