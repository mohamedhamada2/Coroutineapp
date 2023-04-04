package com.mz.coroutineapp.api

import com.mz.coroutineapp.CategoryModel
import com.mz.coroutineapp.home.ImageModel
import com.mz.coroutineapp.login.User
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface BFEApi {
    @GET("api_clients/Api_clients/get_categories")
    suspend fun get_categories() : Response<CategoryModel>

    @FormUrlEncoded
    @POST("api_clients/Api_clients/login")
    suspend fun user_login(@Field("mob")mob:String,@Field("password")password:String) : Response<User>

    @GET("api_clients/Api_clients/get_slideimages")
    fun get_slider( ): Single<ImageModel>
}