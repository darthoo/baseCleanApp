package com.arentator.domain.model

/**
 * Created by Nikolay on 01.03.2018.
 */
data class User (
        val id:Int,
        val firstName:String,
        val lastName:String,
        val avatar:String? = null
)