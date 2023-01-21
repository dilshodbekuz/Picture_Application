package com.example.pictureapplication.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiServise {

    var retrofit: Retrofit? = null

    fun apiCLient(): Api {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://dummyapi.io/data/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(Api::class.java)
    }

    fun apiDog():Api {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/breed/African/images/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(Api::class.java)
    }

    fun apiImage():Api{
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl("https://pixabay.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(Api::class.java)
    }
    fun apiDisney():Api{
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl("https://api.disneyapi.dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(Api::class.java)
    }
}