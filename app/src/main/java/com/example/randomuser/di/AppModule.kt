package com.example.randomuser.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.randomuser.data.remote.api.UserApi
import com.example.randomuser.data.remote.api.UserList
import com.example.randomuser.data.remote.ktor.KtorImpl
import com.example.randomuser.data.remote.retrofit.RetrofitImpl
import com.example.randomuser.data.repository.UserRepositoryImpl
import com.example.randomuser.data.source.UserDataSource
import com.example.randomuser.data.source.UserListPagingSource
import com.example.randomuser.domain.repository.UserRepository
import com.example.randomuser.domain.usecase.LoadRandomPagingUserListUseCase
import com.example.randomuser.domain.usecase.LoadRandomUserUseCase
import com.example.randomuser.presentation.fragment.RandomUserFragment
import com.example.randomuser.presentation.fragment.UserListFragment
import com.example.randomuser.presentation.viewmodel.RandomUserViewModel
import com.example.randomuser.presentation.viewmodel.UserListViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RandomUserViewModel::class)
    abstract fun provideRandomUserViewModel(viewModel: RandomUserViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserListViewModel::class)
    abstract fun provideUserListViewModel(viewModel: UserListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory

}


@Module
internal class UseCaseModule {

    @Singleton
    @Provides
    fun provideLoadRandomPagingUserListUseCase(remoteApi: UserList) = LoadRandomPagingUserListUseCase(remoteApi)

    @Singleton
    @Provides
    fun provideLoadRandomUserUseCase(repo: UserRepository) = LoadRandomUserUseCase(repo)

}

@Module
internal class RepoModule {

    @Singleton
    @Provides
    fun provideUserRepository(dataSource: UserDataSource): UserRepository = UserRepositoryImpl(dataSource)

}

@Module
internal class DataSourceModule {

    @Singleton
    @Provides
    fun provideUserDataSource(api: UserApi): UserDataSource = UserDataSource(api)

    @Singleton
    @Provides
    fun provideUserListPagingSource(api: UserList): UserListPagingSource = UserListPagingSource(api)

}


@Module
internal class RemoteModule {

    @Singleton
    @Provides
    fun provideKtor(): UserApi = KtorImpl()

    @Singleton
    @Provides
    fun provideRetrofit(): UserList = RetrofitImpl()

}

@Singleton
class AppViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?: creators.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
        try {
            @Suppress("UNCHECKED_CAST")
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}