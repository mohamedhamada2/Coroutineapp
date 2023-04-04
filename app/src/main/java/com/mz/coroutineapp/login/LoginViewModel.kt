package com.mz.coroutineapp.login

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.mz.coroutineapp.MainActivity
import com.mz.coroutineapp.api.BFEApi
import com.mz.coroutineapp.api.RetrofitClientInstance
import kotlinx.coroutines.*

class LoginViewModel {

    var context: Context
    var loginActivity:LoginActivity

    constructor(context: Context) {
        this.context = context
        loginActivity = context as LoginActivity
    }
    fun login_user(userPhone: String, userPassword: String) {
        val bfeApi = RetrofitClientInstance.getInstance().create(BFEApi::class.java)
        GlobalScope.launch(Dispatchers.Main) {
            val result = bfeApi.user_login(userPhone,userPassword)
            if (result.isSuccessful){
                if (result.body()!!.success == 1){
                    Toast.makeText(context,result.body()!!.message,Toast.LENGTH_LONG).show()
                    context.startActivity(Intent(loginActivity,MainActivity::class.java))
                    loginActivity.finish()
                }else{
                    Toast.makeText(context,result.body()!!.message,Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}