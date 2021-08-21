package com.example.ktor_example_01.networking.dto


data class GenericUserDTO(
    val results: List<User> = listOf()
)

data class User(
    val gender: String,
    val phone: String,
    val email: String,
    val name: Name,
    val picture: Picture,
) {
    data class Name(
        val title: String,
        val first: String,
        val last: String
    )
    data class Picture(
        val large: String,
        val medium: String,
        val thumbnail: String
    )
}