package com.arentator.arentator

/**
 * Created by Nikolay on 01.03.2018.
 */
data class UserModel(
        val id: Int,
        val firstName: String,
        val lastName: String,
        val avatar: String? = null
)