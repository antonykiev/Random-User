package com.example.randomuser.data.remote.api

import com.example.randomuser.data.dto.BaseResponse
import com.example.randomuser.data.dto.UserResponse
import com.example.randomuser.data.remote.HttpRoutes
import retrofit2.http.GET

interface UserApi {

    @GET(HttpRoutes.GET_RANDOM)
    suspend fun getRandomUser(): BaseResponse<List<UserResponse>>

}