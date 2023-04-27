package com.app.domain.cat

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.data.cat_repository.CatDao.Companion.CAT_TABLE

@Entity(tableName = CAT_TABLE)
data class CatDTO(
    @PrimaryKey(autoGenerate = false)
    val id: String
) {
    fun toModel(): Cat {
        return Cat(
            id = this.id
        )
    }
}