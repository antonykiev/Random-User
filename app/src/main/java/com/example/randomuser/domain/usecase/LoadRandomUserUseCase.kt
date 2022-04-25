package com.example.randomuser.domain.usecase

import com.example.randomuser.data.remote.api.*
import com.example.randomuser.data.remote.ktor.KtorImpl
import com.example.randomuser.data.remote.retrofit.RetrofitImpl
import com.example.randomuser.data.repository.UserRepositoryImpl
import com.example.randomuser.data.source.UserDataSource
import com.example.randomuser.domain.entity.User
import com.example.randomuser.domain.repository.UserRepository

class LoadRandomUserUseCase(
    private val repo: UserRepository,
) {

    suspend fun launch(): Result<User> = repo.getRandomUser().map { it.first() }

}