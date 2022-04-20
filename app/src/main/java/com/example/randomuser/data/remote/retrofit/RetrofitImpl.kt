package com.example.randomuser.data.remote.retrofit

import com.example.randomuser.data.dto.BaseResponse
import com.example.randomuser.data.dto.UserResponse
import com.example.randomuser.data.remote.api.RemoteApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitImpl(): RemoteApi {

    private val service = Retrofit.Builder()
        .baseUrl("https://randomuser.me")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RemoteApi::class.java)

    override suspend fun getRandomUser(): BaseResponse<List<UserResponse>> {
        return service.getRandomUser()
    }
}