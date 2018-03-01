package com.arentator.arentator.presenter.impl

import com.arentator.arentator.UseCaseFlow
import com.arentator.arentator.mapper.UserModelMapper
import com.arentator.arentator.presenter.abstraction.MainActivityPresenter
import com.arentator.arentator.view.abstraction.MainActivityView
import com.arentator.arentator.view.base.BasePresenter
import com.arentator.domain.interactor.LoadUsersUseCase
import com.arentator.domain.model.Users
import javax.inject.Inject

/**
 * Created by Nikolay on 01.03.2018.
 */
class MainActivityPresenterImpl @Inject constructor(
        private val loadUserFlow:UseCaseFlow<Unit,Users,LoadUsersUseCase>,
        private val userModelMapper: UserModelMapper
):BasePresenter<MainActivityView>(), MainActivityPresenter {
    override fun loadUsers() {
        loadUserFlow.run(Unit){
            val userModels = it.users.map { userModelMapper.transformFromDomain(it) }
            view.showUsers(userModels)
        }
    }
}