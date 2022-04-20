package com.example.randomuser.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class Street(
    val number: Int,
    val name: String
)
