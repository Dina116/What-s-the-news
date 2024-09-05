package com.training.whatsthenews

import retrofit2.Call
import retrofit2.http.GET

interface NewsCallable {

    @GET("/v2/everything?q=general&apiKey=48836691b89448859d25f09442851da6")
    fun getGeneralNews(): Call<News>

    @GET("/v2/everything?q=health&apiKey=48836691b89448859d25f09442851da6")
    fun getHealthNews(): Call<News>

    @GET("/v2/everything?q=business&apiKey=48836691b89448859d25f09442851da6")
    fun getBusinessNews(): Call<News>

    @GET("/v2/everything?q=sports&apiKey=48836691b89448859d25f09442851da6")
    fun getSportNews(): Call<News>

    @GET("/v2/everything?q=technology&apiKey=48836691b89448859d25f09442851da6")
    fun getTechnoNews(): Call<News>

}