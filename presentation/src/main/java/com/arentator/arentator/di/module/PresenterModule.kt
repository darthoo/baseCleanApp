package com.arentator.arentator.di.module

import com.arentator.arentator.di.PerActivity
import com.arentator.arentator.presenter.abstraction.MainActivityPresenter
import com.arentator.arentator.presenter.impl.MainActivityPresenterImpl
import dagger.Binds
import dagger.Module

/**
 * Created by Nikolay on 01.03.2018.
 */
@Module()
@PerActivity
interface PresenterModule {

    @Binds
    fun mainActivityPresenter(presenter: MainActivityPresenterImpl): MainActivityPresenter
}