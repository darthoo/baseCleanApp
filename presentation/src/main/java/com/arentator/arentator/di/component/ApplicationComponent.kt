package com.arentator.arentator.di.component

import com.arentator.arentator.ArentatorApp
import com.arentator.arentator.di.PerApplication
import com.arentator.arentator.di.module.ActivityModule
import com.arentator.arentator.di.module.ApplicationModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by Nikolay on 18.02.2018.
 */
@PerApplication
@Component(modules = arrayOf(ApplicationModule::class,ActivityModule::class,AndroidSupportInjectionModule::class))
interface ApplicationComponent : AndroidInjector<ArentatorApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ArentatorApp>()
}