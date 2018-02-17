package com.arentator.arentator.di.module

import com.arentator.arentator.ArentatorApp
import com.arentator.arentator.di.PerApplication
import com.arentator.arentator.di.UIThread
import com.arentator.data.executor.JobExecutor
import com.arentator.domain.executor.PostExecutionThread
import com.arentator.domain.executor.ThreadExecutor
import dagger.Module
import dagger.Provides

/**
 * Created by Nikolay on 18.02.2018.
 */
@Module()
class ApplicationModule {

    @Provides
    @PerApplication
    fun provideApplicationContext(application: ArentatorApp) = application.applicationContext

    @Provides
    @PerApplication
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @PerApplication
    fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread {
        return uiThread
    }

}