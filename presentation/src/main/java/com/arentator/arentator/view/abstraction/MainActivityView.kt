package com.arentator.arentator.view.abstraction

import com.arentator.arentator.UserModel
import com.arentator.arentator.view.base.BaseView

/**
 * Created by Nikolay on 01.03.2018.
 */
interface MainActivityView : BaseView {

    fun showUsers(users:List<UserModel>)
}