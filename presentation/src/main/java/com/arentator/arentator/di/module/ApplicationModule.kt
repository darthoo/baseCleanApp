package com.arentator.arentator.di.module

import com.arentator.arentator.ArentatorApp
import com.arentator.arentator.di.PerApplication
import com.arentator.arentator.di.UIThread
import com.arentator.data.executor.JobExecutor
import com.arentator.data.repository.StubDataStorage
import com.arentator.domain.executor.PostExecutionThread
import com.arentator.domain.executor.ThreadExecutor
import com.arentator.domain.repository.DataRepository
import dagger.Module
import dagger.Provides

/**
 * Created by Nikolay on 18.02.2018.
 */
@Module(includes = arrayOf(PresenterModule::class))
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

    @Provides
    @PerApplication
    fun provideDataRepository(storage: StubDataStorage): DataRepository {
        return storage
    }

}