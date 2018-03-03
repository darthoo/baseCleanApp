package com.arentator.arentator.view.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.View

import com.arentator.arentator.R
import com.arentator.arentator.UserAdapter
import com.arentator.arentator.UserModel
import com.arentator.arentator.adapter.VerticalDivider
import com.arentator.arentator.presenter.abstraction.MainActivityPresenter
import com.arentator.arentator.view.abstraction.MainActivityView
import com.arentator.arentator.view.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainActivityView, MainActivityPresenter>(R.layout.activity_main), MainActivityView {

    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
        presenter.loadUsers()
    }

    private fun setupRecyclerView() {
        userAdapter = UserAdapter { user, sharedView ->
            navigateToUserDetailsView(user, sharedView)
        }
        userRecyclerView.adapter = userAdapter
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.addItemDecoration(VerticalDivider(16))
    }

    private fun navigateToUserDetailsView(user: UserModel, sharedView: View) {
        val intent = ProfileActivity.getCallingIntent(this, user)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, sharedView, sharedView.transitionName)
        startActivity(intent, options.toBundle())
    }

    override fun showUsers(users: List<UserModel>) {
        userAdapter.addUsers(users.toMutableList())
    }
}
