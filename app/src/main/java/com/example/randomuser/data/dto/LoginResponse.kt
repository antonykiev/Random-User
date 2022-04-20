package com.example.randomuser.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val md5: String,
    val password: String,
    val salt: String,
    val sha1: String,
    val sha256: String,
    val username: String,
    val uuid: String
)