package com.example.randomuser.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class Dob(
    val age: Int,
    val date: String
)