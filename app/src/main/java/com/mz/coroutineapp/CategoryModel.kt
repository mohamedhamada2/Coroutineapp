package com.mz.coroutineapp


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class CategoryModel(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status_code")
    val statusCode: Int,
    @SerializedName("success")
    val success: Int
)