package com.arentator.domain.interactor

import com.arentator.domain.model.Users
import com.arentator.domain.repository.DataRepository
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Nikolay on 01.03.2018.
 */
class LoadUsersUseCase @Inject constructor(
        private val dataRepository: DataRepository
) : UseCase<Unit, Users>() {
    override fun buildUseCaseObservable(params: Unit): Observable<Users> {
        return dataRepository.loadUsers().toObservable()
    }
}