package com.arentator.arentator.presenter.abstraction

import com.arentator.arentator.view.abstraction.MainActivityView

/**
 * Created by Nikolay on 01.03.2018.
 */
interface MainActivityPresenter : Presenter<MainActivityView> {

    fun loadUsers()
}