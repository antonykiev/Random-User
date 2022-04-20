package com.example.randomuser.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val cell: String,
    val dob: DobResponse,
    val email: String,
    val gender: String,
    val id: IdResponse,
    val location: LocationResponse,
    val login: LoginResponse,
    val name: NameResponse,
    val nat: String,
    val phone: String,
    val picture: PictureResponse,
    val registered: RegisteredResponse
)