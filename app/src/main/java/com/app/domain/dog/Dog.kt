package com.app.domain.dog

data class Dog(
    val id: String
) {
    fun toDTO(): DogDTO {
        return DogDTO(
            id = this.id
        )
    }
}