package com.seoulapp.startpick

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager



class WithDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_detail)

        /* 상태바 없애기 */
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }
}
