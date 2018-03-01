package com.arentator.arentator.view.base

import android.content.Context
import android.util.Log
import com.arentator.arentator.IDisposable
import com.arentator.arentator.Navigator
import com.arentator.arentator.presenter.abstraction.Presenter
import java.lang.ref.WeakReference
import javax.inject.Inject

/**
 * Created by Nikolay on 01.03.2018.
 */
abstract class BasePresenter<V : BaseView> : Presenter<V> {

    protected var viewContext: WeakReference<Context>? = null

    @Inject lateinit var navigator: Navigator

    protected lateinit var view: V

    override fun resume() {}

    override fun pause() {}

    override fun destroy() {
        viewContext = null
        javaClass.declaredFields
                .filter { IDisposable::class.java.isAssignableFrom(it.type) }
                .forEach {
                    try {
                        it.isAccessible = true
                        (it.get(this) as IDisposable).dispose()
                    } catch (e: IllegalAccessException) {
                        Log.e("Base Presenter", "Can't dispose behavior", e)
                    }
                }
    }

    override fun setMvpView(view: V) {
        this.view = view
        viewContext = WeakReference(view.viewContext)
    }

}