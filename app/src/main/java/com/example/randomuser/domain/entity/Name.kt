package com.example.randomuser.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class Name(
    val first: String,
    val last: String,
    val title: String
)