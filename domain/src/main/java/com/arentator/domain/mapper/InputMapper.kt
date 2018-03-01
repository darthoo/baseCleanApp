package com.arentator.domain.mapper

/**
 * Created by Nikolay on 01.03.2018.
 */
interface InputMapper<in From, out To> {
    fun transformToDomain(item: From): To
}