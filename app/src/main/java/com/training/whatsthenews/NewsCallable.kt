package com.training.whatsthenews

import retrofit2.Call
import retrofit2.http.GET

interface NewsCallable {

    @GET("/v2/everything?q=general&apiKey=b8cf8e3608cc463981aa21c1f53a317d")
    fun getGeneralNews(): Call<News>

    @GET("/v2/everything?q=health&apiKey=b8cf8e3608cc463981aa21c1f53a317d")
    fun getHealthNews(): Call<News>

    @GET("/v2/everything?q=business&apiKey=b8cf8e3608cc463981aa21c1f53a317d")
    fun getBusinessNews(): Call<News>

    @GET("/v2/everything?q=sports&apiKey=b8cf8e3608cc463981aa21c1f53a317d")
    fun getSportNews(): Call<News>

    @GET("/v2/everything?q=technology&apiKey=b8cf8e3608cc463981aa21c1f53a317d")
    fun getTechnoNews(): Call<News>

}