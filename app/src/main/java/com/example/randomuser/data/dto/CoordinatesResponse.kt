package com.example.randomuser.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoordinatesResponse(
    val latitude: String,
    val longitude: String
)