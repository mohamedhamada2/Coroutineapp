package com.mz.coroutineapp.application

import android.app.Application
import com.alatheer.dagger.ApiModule
import com.alatheer.dagger.AppModule
import com.mz.coroutineapp.dagger.Apicomponent
import com.mz.coroutineapp.dagger.DaggerApicomponent

class MyApplication :Application() {
    lateinit var apicomponent: Apicomponent
    override fun onCreate() {
        super.onCreate()
        apicomponent = DaggerApicomponent.builder()
            .apiModule(ApiModule("https://b.f.e.one-click.solutions/"))
            .appModule(AppModule(this)).build()
    }
    fun getNetComponent(): Apicomponent {
        return apicomponent
    }
}