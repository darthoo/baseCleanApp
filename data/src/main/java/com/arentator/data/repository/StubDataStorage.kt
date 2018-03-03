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
                UserEntity(3, "Edward", "Norton", "http://the-talks.com/wp-content/uploads/2012/08/Edward-Norton-01.jpg"),
                UserEntity(4, "Janifer", "Lawrence", "http://magazin.lufthansa.com/content/uploads/2017/01/ddp_Lawrence_Artikelbild-477x673.jpg"),
                UserEntity(5, "Ryan", "Gosling", "https://proxy12.online.ua/parni/r3-2f1b2df3b2/middle_585108166bedb.jpg"),
                UserEntity(6, "Jared", "Leto", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7-wsqvetSth02xAilZ5XPJW8ZHjlHwoEIBR8GcYXQpC_L4-yInQ"),
                UserEntity(7, "James", "Franco", "https://static2.stuff.co.nz/1303288558/856/4912856.jpg")
        )

        val usersDomainModel = Users(users.map { userEntityMapper.transformToDomain(it) }.toMutableList())
        return Single.just(usersDomainModel)
    }
}