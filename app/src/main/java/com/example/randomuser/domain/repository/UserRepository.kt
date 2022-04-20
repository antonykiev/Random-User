package com.example.randomuser.domain.repository

import com.example.randomuser.domain.entity.User

interface UserRepository {

    suspend fun getRandomUser(): Result<List<User>>

}