package com.arentator.arentator.view

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.transition.Explode
import com.arentator.arentator.R
import kotlinx.android.synthetic.main.view_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            userAvatar.translationZ = 6f
            userAvatar.invalidate()
        }

    }
}
