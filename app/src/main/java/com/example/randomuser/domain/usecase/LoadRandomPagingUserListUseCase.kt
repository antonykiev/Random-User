package com.example.randomuser.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.randomuser.data.dto.UserResponse
import com.example.randomuser.data.remote.api.RemoteApi
import com.example.randomuser.data.remote.api.UserApi
import com.example.randomuser.data.remote.api.UserList
import com.example.randomuser.data.remote.ktor.KtorImpl
import com.example.randomuser.data.remote.retrofit.RetrofitImpl
import com.example.randomuser.data.source.UserListPagingSource
import kotlinx.coroutines.flow.Flow

class LoadRandomPagingUserListUseCase() {

    private val remoteApi: RemoteApi by lazy {
        RetrofitImpl()
//        KtorImpl()
    }

    fun load(): Flow<PagingData<UserResponse>> {
        return Pager(
            config = PagingConfig(
                pageSize = UserList.defaultPageSize,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UserListPagingSource(remoteApi) }
        ).flow
    }


}