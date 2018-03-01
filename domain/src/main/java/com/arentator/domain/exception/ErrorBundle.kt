package com.arentator.domain.exception

/**
 * Created by Nikolay on 01.03.2018.
 */
interface ErrorBundle {
    val exception: Throwable
    val errorMessage: String
}