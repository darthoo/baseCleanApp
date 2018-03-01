package com.arentator.data.repository

import com.arentator.data.UserEntityMapper
import com.arentator.data.entity.UserEntity
import com.arentator.domain.model.Users
import com.arentator.domain.repository.DataRepository
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Nikolay on 01.03.2018.
 */
class StubDataStorage @Inject constructor(
        private val userEntityMapper: UserEntityMapper
) : DataRepository {

    override fun loadUsers(): Single<Users> {
        val users = listOf(
                UserEntity(1, "Elizabeth", "Olsen", "https://bostoncommon-magazine.com/get/files/image/galleries/Ashley-olsen-1.jpg"),
                UserEntity(2, "Brad", "Pit", "https://www.usmagazine.com/wp-content/uploads/brad-pitt-inline-2cc38547-b50a-44ef-a31e-42b4024eaba2.jpg"),
                UserEntity(1, "Edward", "Norton", "http://the-talks.com/wp-content/uploads/2012/08/Edward-Norton-01.jpg")
        )

        val usersDomainModel = Users(users.map { userEntityMapper.transformToDomain(it) }.toMutableList())
        return Single.just(usersDomainModel)
    }
}