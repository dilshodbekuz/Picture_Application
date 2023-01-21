package com.example.pictureapplication.model

import java.io.Serializable

data class Model(
    val firstName: String,
    val id: String,
    val lastName: String,
    val picture: String,
    val title: String
):Serializable