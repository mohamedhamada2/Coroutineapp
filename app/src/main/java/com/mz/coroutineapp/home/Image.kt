package com.mz.coroutineapp.home


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Image(
    @SerializedName("date")
    val date: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("title")
    val title: String
)