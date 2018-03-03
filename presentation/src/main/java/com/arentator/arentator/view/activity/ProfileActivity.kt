package com.arentator.arentator.view.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionInflater
import com.arentator.arentator.R
import android.transition.Transition
import android.transition.TransitionSet
import android.util.Log
import android.view.MenuItem

import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import android.view.animation.OvershootInterpolator
import com.arentator.arentator.UserModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.view_contact_details.*


class ProfileActivity : AppCompatActivity() {

    private lateinit var user: UserModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        extractIntentExtraAndShowUser()
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        window.sharedElementEnterTransition.addListener(object : Transition.TransitionListener {
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

        animateContactDetails()
    }

    private fun extractIntentExtraAndShowUser() {
        user = intent.getParcelableExtra(USER)
        val username = "${user.firstName} ${user.lastName}"
        collapsingToolbar.title = username
        user.avatar?.let {

            Glide.with(this)
                    .load(user.avatar!!)
                    .into(roundedImage)

            Glide.with(this)
                    .load(user.avatar!!)
                    .into(toolbarImage)
        }

    }

    private fun animateContactDetails() {
        val slideFromBottomAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_slide_from_bottom)
        slideFromBottomAnimation.interpolator = OvershootInterpolator()
        phoneNumberRoot.startAnimation(slideFromBottomAnimation)
        emailRoot.startAnimation(slideFromBottomAnimation)
        aboutMeCard.startAnimation(slideFromBottomAnimation)
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
                        }
                    })
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

        toolbarImage.visibility = View.VISIBLE

        anim.addListener(object : Animator.AnimatorListener {
            override fun onAnimationEnd(p0: Animator?) {

            }

            override fun onAnimationRepeat(p0: Animator?) {
                Log.e("asd", "REPEATT"
                )
            }

            override fun onAnimationCancel(p0: Animator?) {}
            override fun onAnimationStart(p0: Animator?) {
                roundedImage.animate().alpha(0f)
                Log.e("asd", "=== ROUNDED IMAGE GONE ===")
            }

        })
        anim.start()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        item?.let {
            if (it.itemId == android.R.id.home) {
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
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

    companion object {
        const val USER = "user"

        fun getCallingIntent(context: Context, user: UserModel): Intent {
            val intent = Intent(context, ProfileActivity::class.java)
            intent.putExtra(USER, user)
            return intent
        }
    }

}
