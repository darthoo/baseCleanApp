package com.arentator.arentator.view

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.transition.Explode
import android.transition.TransitionInflater
import com.arentator.arentator.R
import kotlinx.android.synthetic.main.view_profile.*
import android.opengl.ETC1.getWidth
import android.transition.ChangeClipBounds
import android.transition.Transition

import android.view.View
import android.view.ViewAnimationUtils


class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        window.sharedElementEnterTransition.addListener(object :Transition.TransitionListener{
            override fun onTransitionEnd(p0: Transition?) {
                reveal()
            }
            override fun onTransitionResume(p0: Transition?) {}
            override fun onTransitionPause(p0: Transition?) {}
            override fun onTransitionCancel(p0: Transition?) {}
            override fun onTransitionStart(p0: Transition?) {}

        })
    }

    fun reveal() {
        val center = roundedImage.getCenter()
        val anim = ViewAnimationUtils.createCircularReveal(toolbarImage, center.first.toInt(),
                center.second.toInt(), 0f, toolbarImage.width.toFloat())
                .apply {
                    duration = 400
                }
        toolbarImage.visibility = View.VISIBLE
        anim.start()
    }

    fun View.getCenter(): Pair<Float, Float> {
        val cx = this.x + this.width / 2
        val cy = this.y + this.height / 2
        return Pair(cx, cy)
    }

}
