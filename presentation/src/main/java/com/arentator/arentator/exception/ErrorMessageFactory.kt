package com.arentator.arentator.exception

import android.content.Context
import com.arentator.arentator.R
import java.net.UnknownHostException

/**
 * Created by Nikolay on 01.03.2018.
 */
object ErrorMessageFactory {

    /**
     * Creates a String representing an error message.
     *
     * @param context   Context needed to retrieve string resources.
     * @param exception An exception used as a condition to retrievse the correct error message.
     * @return [String] an error message.
     */
    fun create(context: Context, exception: Throwable?): String {
        var message = context.getString(R.string.exception_message_generic)

        if (exception != null) {
            if (exception is UnknownHostException) {
                message = context.getString(R.string.please_check_your_internet_connection)
            } else {
                if (exception.message != null) {
                    message = exception.message
                }
            }
        }


        return message
    }
}//empty