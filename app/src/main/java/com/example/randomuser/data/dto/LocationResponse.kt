package com.example.randomuser.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class LocationResponse(
    val city: String,
    val coordinates: CoordinatesResponse,
    val postcode: String,
    val state: String,
    val street: StreetResponse,
    val timezone: TimezoneResponse
)