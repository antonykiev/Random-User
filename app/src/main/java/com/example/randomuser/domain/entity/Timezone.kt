package com.example.randomuser.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class Timezone(
    val description: String,
    val offset: String
)