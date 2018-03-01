package com.arentator.data

import com.arentator.data.entity.UserEntity
import com.arentator.domain.mapper.InputMapper
import com.arentator.domain.mapper.OutputMapper
import com.arentator.domain.model.User
import javax.inject.Inject

/**
 * Created by Nikolay on 01.03.2018.
 */
class UserEntityMapper @Inject constructor():InputMapper<UserEntity,User>, OutputMapper<User, UserEntity> {

    override fun transformToDomain(item: UserEntity): User {
        return User(
                item.id,
                item.firstName,
                item.lastName,
                item.avatar
        )
    }

    override fun transformFromDomain(item: User): UserEntity {
        return UserEntity(
                item.id,
                item.firstName,
                item.lastName,
                item.avatar
        )
    }


}