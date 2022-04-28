package com.example.randomuser.di

import com.example.randomuser.presentation.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [
        FragmentBuilderModule::class,
    ])
    abstract fun mainActivity(): MainActivity
}