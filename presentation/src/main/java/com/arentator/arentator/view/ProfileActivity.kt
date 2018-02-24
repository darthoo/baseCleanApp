package com.arentator.arentator.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
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
import android.transition.TransitionSet
import android.util.Log

import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation


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

        val transition = TransitionInflater.from(this).inflateTransition(R.transition.changebounds_with_arc)

        val outSet = TransitionSet()
                .apply {
                    addTransition(transition)
                    duration = 380
                    interpolator = AccelerateDecelerateInterpolator()
                    startDelay = 200
                }
        window.sharedElementExitTransition = outSet
        window.sharedElementReturnTransition = outSet
    }

    private fun hideView() {
        roundedImage.animate().alpha(1f)
        val center = roundedImage.getCenter()
        ViewAnimationUtils.createCircularReveal(toolbarImage, center.first.toInt(),
                center.second.toInt(), toolbarImage.width.toFloat(), 0f)
                .apply {
                    duration = 5000
                    addListener(object : AnimatorListenerAdapter() {
                        override fun onAnimationEnd(animation: Animator?) {
                            super.onAnimationEnd(animation)
                            toolbarImage.visibility = View.INVISIBLE
                        }})
                    start()
                }
    }

    fun reveal() {
        val center = roundedImage.getCenter()
        val anim = ViewAnimationUtils.createCircularReveal(toolbarImage, center.first.toInt(),
                center.second.toInt(), 0f, toolbarImage.width.toFloat())
                .apply {
                    duration = 400
                }

        toolbarImage.setImageDrawable(resources.getDrawable(R.drawable.user_avatar))
        toolbarImage.visibility = View.VISIBLE

        anim.addListener(object : Animator.AnimatorListener{
            override fun onAnimationEnd(p0: Animator?) {

            }
            override fun onAnimationRepeat(p0: Animator?) {
                Log.e("asd","REPEATT"
                )
            }
            override fun onAnimationCancel(p0: Animator?) {}
            override fun onAnimationStart(p0: Animator?) {
                roundedImage.animate().alpha(0f)
                Log.e("asd","=== ROUNDED IMAGE GONE ===")}

        })
        anim.start()


    }

    fun View.getCenter(): Pair<Float, Float> {
        val cx = this.x + this.width / 2
        val cy = this.y + this.height / 2
        return Pair(cx, cy)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        hideView()
    }

}
