package com.arentator.arentator.di.module

import com.arentator.arentator.di.PerActivity
import com.arentator.arentator.view.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by Nikolay on 18.02.2018.
 */
@Module(includes = arrayOf(AndroidSupportInjectionModule::class, FragmentModule::class))
interface ActivityModule {

    @ContributesAndroidInjector
    @PerActivity
    fun mainActivity(): MainActivity
}