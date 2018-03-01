package com.arentator.arentator.view.base

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import com.arentator.arentator.presenter.abstraction.Presenter
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Created by Nikolay on 01.03.2018.
 */
abstract class BaseFragment <V: BaseView, P : Presenter<V>>(private val layoutId:Int) : DaggerFragment(), BaseView {

    @Inject protected lateinit var presenter:P
    private var defaultProgress: ProgressBar?= null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(layoutId, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.setMvpView(this as V)

        activity?.let {
            it.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
        }
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }

    override fun showToastMessage(message: String, length: Int) {
        Toast.makeText(activity,message,length).show()
    }

    override val viewContext: Context
        get() = activity as Context

    override fun showLoading() {
        defaultProgress?.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        defaultProgress?.visibility = View.GONE
    }
}