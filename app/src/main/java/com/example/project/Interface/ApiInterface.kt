package com.example.project.Interface

import com.example.project.DataClass.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query



const val BASE_URL="https://newsapi.org/"
const val API_KEY="b3a51abb898d41ac8584930d4f30928e"
interface ApiService {

    @GET("/v2/top-headlines?apiKey=$API_KEY")
    fun getHeadLines(@Query("country")country: String ,@Query("page") page: Int) : Call<News>
}

object ApiInterface{
    val apiInstance: ApiService
    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        apiInstance = retrofit.create(ApiService::class.java)
    }
}