package com.mz.coroutineapp.home


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ImageModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("status_code")
    val statusCode: Int,
    @SerializedName("success")
    val success: Int
)