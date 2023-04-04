package com.mz.coroutineapp.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.databinding.DataBindingUtil
import com.mz.coroutineapp.R
import com.mz.coroutineapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var activityLoginBinding: ActivityLoginBinding
    lateinit var loginViewModel2: LoginViewModel
    lateinit var user_phone :String
    lateinit var user_password:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        activityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        loginViewModel2 = LoginViewModel(this)
        activityLoginBinding.loginviewmodel = loginViewModel2

    }

    fun Login(view: View) {
        user_phone = activityLoginBinding.etPhone.text.toString()
        user_password = activityLoginBinding.etPassword.text.toString();
        validation(user_phone,user_password)

    }

    private fun validation(user_phone:String,user_password:String) {
        if (!TextUtils.isEmpty(user_phone)&&!TextUtils.isEmpty(user_password)){
            loginViewModel2.login_user(user_phone,user_password)
        }else{
            if (TextUtils.isEmpty(user_phone)){
                activityLoginBinding.etPhone.setError("أدخل رقم الجوال")
            }else{
                activityLoginBinding.etPhone.setError(null)
            }
            if (TextUtils.isEmpty(user_password)){
                activityLoginBinding.etPassword.setError("أدخل كلمة المرور")
            }else{
                activityLoginBinding.etPassword.setError(null)
            }
        }
    }
}