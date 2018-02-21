package com.arentator.arentator.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.view.View

import com.arentator.arentator.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        card.setOnClickListener{startProfileActivity()}
    }

    private fun startProfileActivity(){
        val avatarTransition = resources.getString(R.string.user_avatar_transition)
        val intent = Intent(this, ProfileActivity::class.java)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, avatar as View, avatarTransition)
        startActivity(intent, options.toBundle())
    }
}
