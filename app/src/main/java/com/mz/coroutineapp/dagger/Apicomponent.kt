package com.mz.coroutineapp.dagger

import com.alatheer.dagger.ApiModule
import com.alatheer.dagger.AppModule
import com.mz.coroutineapp.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,ApiModule::class])
interface Apicomponent {
    fun inject2(mainActivity: MainActivity)
}