package com.example.randomuser.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class StreetResponse(
    val number: Int,
    val name: String
)
