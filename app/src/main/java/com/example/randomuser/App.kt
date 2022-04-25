package com.example.randomuser

import android.app.Application
import com.example.randomuser.di.MainDi
import com.example.randomuser.di.ModuleDependencies

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
//            androidLogger()
            androidContext(this@App)

            arrayOf(
                MainDi,
            )
                .flatMap(ModuleDependencies::batch)
                .apply(::modules)
        }
    }
}