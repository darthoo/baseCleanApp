package com.arentator.arentator.mapper

import com.arentator.arentator.UserModel
import com.arentator.domain.mapper.InputMapper
import com.arentator.domain.mapper.OutputMapper
import com.arentator.domain.model.User
import javax.inject.Inject

/**
 * Created by Nikolay on 01.03.2018.
 */
class UserModelMapper @Inject constructor() : InputMapper<UserModel, User>, OutputMapper<User, UserModel> {
    override fun transformToDomain(item: UserModel): User {
        return User(
                item.id,
                item.firstName,
                item.lastName,
                item.avatar
        )
    }

    override fun transformFromDomain(item: User): UserModel {
        return UserModel(
                item.id,
                item.firstName,
                item.lastName,
                item.avatar
        )
    }
}