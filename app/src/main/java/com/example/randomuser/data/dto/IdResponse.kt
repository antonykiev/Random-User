package com.example.randomuser.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class IdResponse(
    val name: String,
    val value: String?,
)