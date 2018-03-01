package com.arentator.domain.mapper

/**
 * Created by Nikolay on 01.03.2018.
 */
interface OutputMapper<in From, out To> {
    fun transformFromDomain(item: From): To
}