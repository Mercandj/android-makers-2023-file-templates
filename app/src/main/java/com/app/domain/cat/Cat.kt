package com.app.domain.cat

data class Cat(
    val id: String
) {
    fun toDTO(): CatDTO {
        return CatDTO(
            id = this.id
        )
    }
}