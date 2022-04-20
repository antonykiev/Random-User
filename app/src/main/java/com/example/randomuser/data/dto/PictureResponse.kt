package com.example.randomuser.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class PictureResponse(
    val large: String,
    val medium: String,
    val thumbnail: String
)