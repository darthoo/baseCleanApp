package com.arentator.arentator

import com.arentator.arentator.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by Nikolay on 18.02.2018.
 */
class ArentatorApp : DaggerApplication() {

    /**
     * @return dagger application level injector
     */
    override fun applicationInjector(): AndroidInjector<out DaggerApplication>?{
        return DaggerApplicationComponent.builder().create(this)
    }

}