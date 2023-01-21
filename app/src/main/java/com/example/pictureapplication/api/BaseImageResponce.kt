package com.example.pictureapplication.api

data class BaseImageResponce<T>(
    val total: Int,
    val totalHits: Int,
    val hits: T
)