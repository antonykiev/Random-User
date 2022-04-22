package com.example.randomuser.data.remote.retrofit

import com.example.randomuser.data.remote.HttpRoutes
import com.example.randomuser.data.remote.api.RemoteApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitImpl(
    private val service: RemoteApi = Retrofit.Builder()
        .baseUrl(HttpRoutes.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RemoteApi::class.java)
) : RemoteApi by service