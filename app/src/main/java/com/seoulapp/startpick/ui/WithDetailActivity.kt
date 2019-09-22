package com.seoulapp.startpick.ui

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.view.View
import android.view.WindowManager
import com.seoulapp.startpick.R
import kotlinx.android.synthetic.main.activity_with_detail.*





class WithDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_detail)

        statusbarTransparency() // 상태바 투명
        btn_back.setOnClickListener {
            finish()
            overridePendingTransition(0, 0)
        }


    }

    /* 상태바 투명하게 만들기 */
    fun statusbarTransparency(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = 0x00000000  // transparent
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val flags = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            window.addFlags(flags)
        }
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }
}
