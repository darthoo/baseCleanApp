package com.arentator.arentator.view.base

import android.content.Context
import android.widget.Toast

/**
 * Created by Nikolay on 01.03.2018.
 */
interface BaseView {

    val viewContext: Context

    fun showToastMessage(message:String, length:Int = Toast.LENGTH_SHORT )

    fun showLoading()

    fun hideLoading()
}