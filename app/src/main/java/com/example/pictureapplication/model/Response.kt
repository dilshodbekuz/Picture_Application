package com.example.pictureapplication.model

import com.example.pictureapplication.api.BaseResponce

data class Response<T>(
    val data: T
)