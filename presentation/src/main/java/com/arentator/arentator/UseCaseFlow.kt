package com.arentator.arentator

import com.arentator.arentator.exception.ErrorMessageFactory
import com.arentator.arentator.view.base.BaseView
import com.arentator.domain.exception.DefaultErrorBundle
import com.arentator.domain.exception.ErrorBundle
import com.arentator.domain.interactor.UseCase
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

/**
 * Created by Nikolay on 01.03.2018.
 */
class UseCaseFlow<
        TParamsType,
        TReturnType,
        TUseCase : UseCase<TParamsType, TReturnType>
        > @Inject constructor() : IDisposable {

    @Inject lateinit var useCase: TUseCase

    private var view: BaseView? = null
    private var consumer: FlowConsumer<TReturnType>? = null


    fun run(params: TParamsType, view: BaseView? = null, callback: ((result: TReturnType) -> Unit)? = null) {
        runWithFullConsumer(params, view, consumer = object : FlowConsumer<TReturnType> {
            override fun onStart() {
                showViewLoading()
            }

            override fun onDataGet(data: TReturnType) {
                callback?.invoke(data)
            }

            override fun onComplete() {
                hideLoading()
            }

            override fun onError(error: ErrorBundle) {
                hideLoading()
                error.exception.printStackTrace()
                showErrorMessage(error)
            }
        })
    }

    private fun runWithFullConsumer(input: TParamsType, view: BaseView? = null, consumer: FlowConsumer<TReturnType>?) {
        this.view = view
        this.consumer = consumer
        this.consumer?.onStart()
        this.getData(input)
    }

    private fun showDataInView(data: TReturnType) {
        consumer?.onDataGet(data)
    }

    private fun showViewLoading() {
        view?.showLoading()
    }

    private fun hideLoading() {
        view?.hideLoading()
    }

    private fun showErrorMessage(errorBundle: ErrorBundle) {
        view?.let {
            val errorMessage = ErrorMessageFactory.create(
                    it.viewContext,
                    errorBundle.exception)
            it.showToastMessage("Error: $errorMessage")
        }
    }

    private fun getData(input: TParamsType) {
        this.useCase.execute(DataObserver(), input)
    }

    private inner class DataObserver : DisposableObserver<TReturnType>() {

        override fun onNext(t: TReturnType) {
            showDataInView(t)
        }

        override fun onComplete() {
            consumer?.onComplete()
        }

        override fun onError(e: Throwable) {
            consumer?.onError(DefaultErrorBundle(e))
        }

    }

    override fun dispose() {
        this.useCase.dispose()
        this.view = null
        this.consumer = null
    }

    override fun clear() {
        this.useCase.clear()
    }

    interface FlowConsumer<T> {
        fun onStart()
        fun onDataGet(data: T)
        fun onComplete()
        fun onError(error: ErrorBundle)
    }
}