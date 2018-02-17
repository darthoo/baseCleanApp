package com.arentator.domain.interactor

import com.arentator.domain.executor.PostExecutionThread
import com.arentator.domain.executor.ThreadExecutor
import com.fernandocejas.arrow.checks.Preconditions
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Nikolay on 18.02.2018.
 */
abstract class UseCase<TReturnType, TParamsType> internal constructor() {

    @Inject lateinit var threadExecutor: ThreadExecutor
    @Inject lateinit var postExecutionThread: PostExecutionThread

    private val disposables: CompositeDisposable = CompositeDisposable()

    /**
     * Builds an [Observable] which will be used when executing the current [UseCase].
     */
    internal abstract fun buildUseCaseObservable(params: TParamsType): Observable<TReturnType>

    /**
     * Executes the current use case.

     * @param observer [DisposableObserver] which will be listening to the observable build
     * * by [.buildUseCaseObservable] ()} method.
     * *
     * @param params Parameters (Optional) used to build/execute this use case.
     */
    fun execute(observer: DisposableObserver<TReturnType>, params: TParamsType) {
        Preconditions.checkNotNull(observer)
        val observable = this.buildUseCaseObservable(params)
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler)
        addDisposable(observable.subscribeWith(observer))
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    fun clear() {
        disposables.clear()
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    private fun addDisposable(disposable: Disposable) {
        Preconditions.checkNotNull(disposable)
        Preconditions.checkNotNull(disposables)
        disposables.add(disposable)
    }
}