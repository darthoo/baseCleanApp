package com.arentator.arentator.presenter.abstraction

import com.arentator.arentator.view.base.BaseView

/**
 * Created by Nikolay on 01.03.2018.
 */
interface Presenter<V : BaseView> {
    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onResume() method.
     */
    fun resume()

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onPause() method.
     */
    fun pause()

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    fun destroy()

    fun setMvpView(view: V)
}