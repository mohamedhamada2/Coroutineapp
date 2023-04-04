package com.mz.coroutineapp


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Data(
    @SerializedName("details")
    val details: Any,
    @SerializedName("form_id")
    val formId: String,
    @SerializedName("have_branch")
    val haveBranch: String,
    @SerializedName("id_setting")
    val idSetting: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("phone")
    val phone: Any,
    @SerializedName("price")
    val price: Any,
    @SerializedName("title_color")
    val titleColor: Any,
    @SerializedName("title_order")
    val titleOrder: Any,
    @SerializedName("title_setting")
    val titleSetting: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("type_name")
    val typeName: String
)