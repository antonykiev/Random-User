package com.example.randomuser.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.randomuser.domain.entity.User
import com.example.randomuser.domain.usecase.LoadRandomUserUseCase
import javax.inject.Inject

class RandomUserViewModel @Inject constructor (
    private val useCase: LoadRandomUserUseCase
): ViewModel() {

    val randomUser: LiveData<State> = liveData {
        emit(State.Loading)
        useCase.launch()
            .fold(
                { emit(State.Result(it)) },
                { emit(State.Error(it)) }
            )
    }

    sealed class State {
        object Loading : State() {
            override fun toString(): String {
                return "Loading"
            }
        }
        data class Result(val value: User): State()
        data class Error(val error: Throwable): State()
    }

}