package com.example.randomuser.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class Registered(
    val age: Int,
    val date: String
)