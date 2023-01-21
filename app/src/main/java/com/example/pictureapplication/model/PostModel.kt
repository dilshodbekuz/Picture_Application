package com.example.pictureapplication.model

data class PostModel(
    val id: String,
    val image: String,
    val likes: Int,
    val firstName: String,
    val owner: Owner,
    val publishDate: String,
    val tags: List<String>,
    val text: String
)