package com.arentator.arentator.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.transition.Transition
import android.view.View

import com.arentator.arentator.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        card.setOnClickListener{startProfileActivity()}

        window.sharedElementEnterTransition.addListener(object : Transition.TransitionListener{
            override fun onTransitionEnd(p0: Transition?) {
                avatar.animate().alpha(1f)
                roundedImage.animate().alpha(0f)
            }
            override fun onTransitionResume(p0: Transition?) {}
            override fun onTransitionPause(p0: Transition?) {}
            override fun onTransitionCancel(p0: Transition?) {}
            override fun onTransitionStart(p0: Transition?) {}

        })
    }

    private fun startProfileActivity(){
        avatar.animate().alpha(0f)
        roundedImage.animate().alpha(1f)
        val avatarTransition = resources.getString(R.string.rounded_color_view_transition)
        val intent = Intent(this, ProfileActivity::class.java)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, roundedImage as View, avatarTransition)
        startActivity(intent, options.toBundle())
    }
}
