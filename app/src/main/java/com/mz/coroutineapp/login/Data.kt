package com.mz.coroutineapp.login


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Data(
    @SerializedName("adress")
    val adress: String,
    @SerializedName("approved")
    val approved: String,
    @SerializedName("city_id_fk")
    val cityIdFk: String,
    @SerializedName("client_code")
    val clientCode: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("day_of_week")
    val dayOfWeek: Any,
    @SerializedName("debt")
    val debt: String,
    @SerializedName("deleted")
    val deleted: String,
    @SerializedName("govern_id_fk")
    val governIdFk: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("mob")
    val mob: String,
    @SerializedName("mob2")
    val mob2: Any,
    @SerializedName("name")
    val name: String,
    @SerializedName("national_num")
    val nationalNum: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("publisher")
    val publisher: Any,
    @SerializedName("shop")
    val shop: String,
    @SerializedName("subscription_id_fk")
    val subscriptionIdFk: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("type")
    val type: String
)