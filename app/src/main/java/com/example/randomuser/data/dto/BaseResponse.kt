package com.example.randomuser.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val results: T,
    val info: Info
)
