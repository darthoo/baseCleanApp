package com.arentator.domain.exception

/**
 * Created by Nikolay on 01.03.2018.
 */
class DefaultErrorBundle(override val exception: Throwable) : ErrorBundle {

    override val errorMessage: String
        get() = this.exception.message ?: DEFAULT_ERROR_MSG

    companion object {
        private val DEFAULT_ERROR_MSG = "Unknown error"
    }
}