package com.example.randomuser.di

import com.example.randomuser.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivityBuilder::class,
    ViewModelModule::class,
    UseCaseModule::class,
    RepoModule::class,
    DataSourceModule::class,
    RemoteModule::class,
])
interface AppComponent: AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent

    }
}