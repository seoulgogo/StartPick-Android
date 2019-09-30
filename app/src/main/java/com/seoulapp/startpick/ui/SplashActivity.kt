package com.seoulapp.startpick.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.seoulapp.startpick.R

class SplashActivity : AppCompatActivity() {

    val SPLASH_TIME : Long = 2000 // 2초

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // 스플래시 엑티비티 활성화
        Handler().postDelayed({
            startActivity(Intent(this, SignMainActivity::class.java))
            finish()
        }, SPLASH_TIME)
    }
}
