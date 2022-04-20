package com.example.randomuser.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val city: String,
    val coordinates: Coordinates,
    val postcode: String,
    val state: String,
    val street: Street,
    val timezone: Timezone
)