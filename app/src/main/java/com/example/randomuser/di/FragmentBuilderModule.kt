package com.example.randomuser.di

import com.example.randomuser.presentation.fragment.RandomUserFragment
import com.example.randomuser.presentation.fragment.UserListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeRandomUserFragment(): RandomUserFragment

    @ContributesAndroidInjector
    abstract fun contributeUserListFragment(): UserListFragment


}