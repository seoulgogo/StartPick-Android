package com.seoulapp.startpick.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.seoulapp.startpick.R
import kotlinx.android.synthetic.main.activity_support_detail.*

class SupportDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_support_detail)

        /* 뒤로가기 버튼 */
        back_arrow.setOnClickListener {
            finish()
        }
    }
}
