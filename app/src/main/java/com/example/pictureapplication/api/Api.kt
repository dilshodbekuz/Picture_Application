package com.example.pictureapplication.api

import com.example.pictureapplication.model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @Headers("app-id:6189261d8cd582ad4e3c9909")
    @GET("user")
    fun getCatImage(): Call<BaseResponce<List<Model>>>

    @Headers("app-id:6189261d8cd582ad4e3c9909")
    @GET("post")
    fun getPost(): Call<BaseResponce<List<PostModel>>>

  /*  @Headers("app-id:6189261d8cd582ad4e3c9909")
    @GET("user/{user_id}/post")
    fun getPostByUser(@Path("user_id") id: String): Call<BaseResponce<List<PostModel>>>*/

    @GET("random")
    fun  getDog(): Call<Test>


    @GET("/api/?key=29361305-c1438b29d2fb14c66d5a7b065")
    fun getImage(
    ): Call<BaseImageResponce<List<Pixaboy>>>

    @GET("characters")
    fun getDisney():Call<Disney<List<DataX>>>

}