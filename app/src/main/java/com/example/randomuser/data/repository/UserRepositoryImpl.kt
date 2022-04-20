package com.example.randomuser.data.repository

import com.example.randomuser.data.remote.api.UserApi
import com.example.randomuser.domain.entity.User
import com.example.randomuser.domain.mapper.UserMapper
import com.example.randomuser.domain.repository.UserRepository
import org.mapstruct.factory.Mappers

class UserRepositoryImpl(private val dataSource: UserApi): UserRepository {

    private val userMapper = Mappers.getMapper(UserMapper::class.java)

    override suspend fun getRandomUser(): Result<List<User>> {
        return runCatching { dataSource.getRandomUser() }
            .map { it.results }
            .map(userMapper::mapResponseToEntityList)
    }
}