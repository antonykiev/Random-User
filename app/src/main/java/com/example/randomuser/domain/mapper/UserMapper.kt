package com.example.randomuser.domain.mapper

import com.example.randomuser.data.dto.*
import com.example.randomuser.domain.entity.*
import org.mapstruct.Mapper

@Mapper(
    uses = [
        DobMapper::class,
        IdMapper::class,
        LocationMapper::class,
        LoginMapper::class,
        PictureMapper::class,
        RegisteredMapper::class,
    ]
)
interface UserMapper {

    fun mapResponseToEntity(response: UserResponse): User

    fun mapResponseToEntityList(response: List<UserResponse>): List<User>

}

@Mapper
interface TimezoneMapper {

    fun mapResponseToEntity(response: TimezoneResponse): Timezone

}

@Mapper
interface StreetMapper {

    fun mapResponseToEntity(response: StreetResponse): Street

}

@Mapper
interface RegisteredMapper {

    fun mapResponseToEntity(response: RegisteredResponse): Registered

}

@Mapper
interface PictureMapper {

    fun mapResponseToEntity(response: PictureResponse): Picture

}

@Mapper
interface NameMapper {

    fun mapResponseToEntity(response: NameResponse): Name

}

@Mapper
interface LoginMapper {

    fun mapResponseToEntity(response: LoginResponse): Login

}

@Mapper(
    uses = [
        CoordinatesMapper::class,
        StreetMapper::class,
        TimezoneMapper::class,
    ]
)
interface LocationMapper {

    fun mapResponseToEntity(response: LocationResponse): Location

}

@Mapper
interface IdMapper {

    fun mapResponseToEntity(response: IdResponse): Id

}

@Mapper
interface DobMapper {

    fun mapResponseToEntity(response: DobResponse): Dob

}

@Mapper
interface CoordinatesMapper {

    fun mapResponseToEntity(response: CoordinatesResponse): Coordinates

}