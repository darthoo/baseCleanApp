package com.arentator.arentator.view.base

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.arentator.arentator.Navigator
import com.arentator.arentator.presenter.abstraction.Presenter
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by Nikolay on 01.03.2018.
 */
abstract class BaseActivity<V: BaseView, P: Presenter<V>>(private val layoutId:Int) : DaggerAppCompatActivity(), BaseView {
    @Inject protected lateinit var presenter:P
    @Inject protected lateinit var navigator: Navigator

    private var defaultProgress: ProgressBar?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        presenter.setMvpView(this as V)
    }

    override val viewContext: Context
        get() = this

    override fun showToastMessage(message: String, length: Int) {
        Toast.makeText(this,message,length).show()
    }

    override fun showLoading() {
        defaultProgress?.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        defaultProgress?.visibility = View.GONE
    }

    override fun onDestroy() {
        presenter.destroy()
        super.onDestroy()
    }
}