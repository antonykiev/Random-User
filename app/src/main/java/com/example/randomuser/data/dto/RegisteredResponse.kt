package com.example.randomuser.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class RegisteredResponse(
    val age: Int,
    val date: String
)