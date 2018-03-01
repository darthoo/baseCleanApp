package com.arentator.arentator.view.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.view.View

import com.arentator.arentator.R
import com.arentator.arentator.UserModel
import com.arentator.arentator.presenter.abstraction.MainActivityPresenter
import com.arentator.arentator.view.abstraction.MainActivityView
import com.arentator.arentator.view.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainActivityView,MainActivityPresenter>(R.layout.activity_main), MainActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.loadUsers()
    }

    private fun startProfileActivity(){
        val avatarTransition = resources.getString(R.string.rounded_color_view_transition)
        val intent = Intent(this, ProfileActivity::class.java)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, avatar as View, avatarTransition)
        startActivity(intent, options.toBundle())
    }

    override fun showUsers(users: List<UserModel>) {
        println()
    }
}
