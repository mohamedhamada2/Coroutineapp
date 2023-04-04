package com.mz.coroutineapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope


import com.mz.coroutineapp.api.BFEApi
import com.mz.coroutineapp.api.RetrofitClientInstance
import com.mz.coroutineapp.home.Image
import com.mz.coroutineapp.home.ImageModel
import com.mz.coroutineapp.login.User
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CategoryViewModel : ViewModel{
    /*lateinit var category_name:String
    lateinit var user: User
    var compositeDisposable = CompositeDisposable()*/
    var mutableLiveData = MutableLiveData<CategoryModel>()
    var mutableLiveData2 = MutableLiveData<ImageModel>()
    var mutablestateflow =MutableStateFlow<CategoryModel>(CategoryModel(listOf<Data>(),"0",0,0));

    constructor() : super()

    fun get_all_data_in_page(bfeApi1: BFEApi) {

        /*al bfeApi = RetrofitClientInstance.getInstance().create(BFEApi::class.java)
        //get_slider(bfeApi)
        val result = bfeApi.get_categories().subscribeOn(Schedulers.io())

        compositeDisposable.add(result.subscribe({ data -> mutableLiveData.postValue(data)},{ e -> Log.e("error", e.message!!)}))*/

        // launching a new coroutine4


        viewModelScope.launch(Dispatchers.Main) {
            Log.e("categories2","success")
            launch { get_categories(bfeApi1) }

            //get_slider(bfeApi)
            //login(bfeApi)
        }
    }

     /*fun get_slider(bfeApi: BFEApi) {
         val result = bfeApi.get_slider().observeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
         result.subscribe({imagemodel -> mutableLiveData2.postValue(imagemodel)})
        if (result != null){
            slider_list = result.body()!!.data.images
            //mainActivity.init_slider(slider_list)
        }
    }*/

    suspend fun get_categories(bfeApi: BFEApi){
        Log.e("categories","success")
        val result = bfeApi.get_categories()
        //delay(3000)
        if (result != null){
            /*mutableLiveData.postValue(result.body())
            Log.d("success1", result.body()?.message!!)*/
             /*mutablestateflow = MutableStateFlow<CategoryModel>(CategoryModel(result.body()!!.data,
                result.body()!!.message,
                result.body()!!.statusCode,
                result.body()!!.success))*/
            mutablestateflow.emit(result.body()!!)
        }

    }
    /*suspend fun login(bfeApi: BFEApi){
        val login_result = bfeApi.user_login("01065242773","123456")
        if (login_result.isSuccessful){
            if (login_result != null){
                user = login_result.body()!!
                Log.d("success2", login_result.body()!!.message)
            }
        }
    }*/

    /*override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }*/

}