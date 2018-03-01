package com.arentator.data.entity

import com.google.gson.annotations.SerializedName

/**
 * Created by Nikolay on 01.03.2018.
 */
data class UserEntity (
        @SerializedName("id") val id:Int,
        @SerializedName("first_name") val firstName:String,
        @SerializedName("last_name") val lastName:String,
        @SerializedName("avatar") val avatar:String? = null
)