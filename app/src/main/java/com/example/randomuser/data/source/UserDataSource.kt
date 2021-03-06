package com.example.randomuser.data.source

import com.example.randomuser.data.dto.BaseResponse
import com.example.randomuser.data.dto.UserResponse
import com.example.randomuser.data.remote.api.UserApi

class UserDataSource(private val api: UserApi): UserApi {

    override suspend fun getRandomUser(): BaseResponse<List<UserResponse>> {
        return api.getRandomUser()
    }

}