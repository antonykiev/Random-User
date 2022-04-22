package com.example.randomuser.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.randomuser.data.dto.UserResponse
import com.example.randomuser.domain.usecase.LoadRandomPagingUserListUseCase
import kotlinx.coroutines.flow.Flow

class UserListViewModel(): ViewModel() {

    private val useCase = LoadRandomPagingUserListUseCase()

    fun loadUserList(): Flow<PagingData<UserResponse>> = useCase.load().cachedIn(viewModelScope)

}