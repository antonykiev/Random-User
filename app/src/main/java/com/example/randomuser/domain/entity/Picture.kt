package com.example.randomuser.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)