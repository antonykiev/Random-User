package com.example.randomuser.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class TimezoneResponse(
    val description: String,
    val offset: String
)