package com.example.pictureapplication.model

data class Disney<T>(
    val count: Int,
    val data: T,
    val nextPage: String,
    val totalPages: Int
)