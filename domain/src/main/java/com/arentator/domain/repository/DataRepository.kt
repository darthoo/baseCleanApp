package com.arentator.domain.repository

import com.arentator.domain.model.Users
import io.reactivex.Single

/**
 * Created by Nikolay on 01.03.2018.
 */
interface DataRepository {

    fun loadUsers() :Single<Users>
}