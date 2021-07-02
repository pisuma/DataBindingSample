package com.example.databindingsample

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.POST

interface ApiEndpoint {
    @POST("postSample")
    fun postSample(): Call<String>
}

object Api {
    val client: ApiEndpoint = Retrofit.Builder()
        .baseUrl("https://api.example.com")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(OkHttpClient())
        .build()
        .create(ApiEndpoint::class.java)
}