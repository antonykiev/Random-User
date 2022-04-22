package com.example.randomuser.data.remote.api

import com.example.randomuser.data.dto.BaseResponse
import com.example.randomuser.data.dto.UserResponse
import com.example.randomuser.data.remote.HttpRoutes
import retrofit2.http.GET
import retrofit2.http.Query

interface UserList {

    companion object {
        const val defaultPageSize: Int = 10

    }

    @GET(HttpRoutes.GET_RANDOM)
    suspend fun getUserUserList(
        @Query("page") page: Int,
        @Query("results") size: Int = defaultPageSize
    ): BaseResponse<List<UserResponse>>
}