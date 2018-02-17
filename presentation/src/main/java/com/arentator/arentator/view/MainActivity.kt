package com.arentator.arentator.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.arentator.arentator.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(Intent(this,RegisterActivity::class.java))
    }
}
