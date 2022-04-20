package com.example.randomuser.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class DobResponse(
    val age: Int,
    val date: String
)