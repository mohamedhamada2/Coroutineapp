package com.mz.coroutineapp.home


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Data(
    @SerializedName("images")
    val images: List<Image>
)