package com.example.randomuser.di

import com.example.randomuser.data.remote.api.RemoteApi
import com.example.randomuser.data.remote.api.UserApi
import com.example.randomuser.data.remote.ktor.KtorImpl
import com.example.randomuser.data.remote.retrofit.RetrofitImpl
import com.example.randomuser.data.repository.UserRepositoryImpl
import com.example.randomuser.data.source.UserDataSource
import com.example.randomuser.data.source.UserListPagingSource
import com.example.randomuser.domain.repository.UserRepository
import com.example.randomuser.domain.usecase.LoadRandomPagingUserListUseCase
import com.example.randomuser.domain.usecase.LoadRandomUserUseCase
import com.example.randomuser.presentation.viewmodel.RandomUserViewModel
import com.example.randomuser.presentation.viewmodel.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

object MainDi : ModuleDependencies {

    private val viewModels: Module = module {
        viewModel { RandomUserViewModel(get()) }
        viewModel { UserListViewModel(get()) }
    }

    private val useCases: Module = module {
        single { LoadRandomPagingUserListUseCase(get()) }
        single { LoadRandomUserUseCase(get()) }
    }

    private val repo: Module = module {
        single<UserRepository> { UserRepositoryImpl(get()) }
    }

    private val dataSource: Module = module {
        single { UserDataSource(get()) }

        single { UserListPagingSource(get()) }
    }

    private val remoteServices: Module = module {
        single<UserApi> { KtorImpl() }
        single<RemoteApi> { RetrofitImpl() }
    }

    override val batch: List<Module>
        get() = listOf(
            viewModels,
            useCases,
            repo,
            dataSource,
            remoteServices
        )

}