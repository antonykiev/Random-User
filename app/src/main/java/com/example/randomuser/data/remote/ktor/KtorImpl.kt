package com.example.randomuser.data.remote.ktor

import com.example.randomuser.data.dto.BaseResponse
import com.example.randomuser.data.dto.UserResponse
import com.example.randomuser.data.remote.HttpRoutes
import com.example.randomuser.data.remote.api.RemoteApi
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

class KtorImpl(
    private val client: HttpClient = HttpClient(Android) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.BODY
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer(
                kotlinx.serialization.json.Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                })
        }
    }
    ): RemoteApi {

    override suspend fun getRandomUser(): BaseResponse<List<UserResponse>> {
        return client.get {
            url(HttpRoutes.GET_RANDOM_URL)
            contentType(ContentType.Application.Json)
        }
    }

    override suspend fun getUserUserList(page: Int, size: Int): BaseResponse<List<UserResponse>> {
        TODO("Not yet implemented")
    }
}