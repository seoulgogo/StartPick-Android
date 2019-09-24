package com.seoulapp.startpick.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.seoulapp.startpick.R
import kotlinx.android.synthetic.main.activity_write.*

class WorkArea : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_area)

        /* 뒤로가기 */
        back_arrow.setOnClickListener {
            finish()
            overridePendingTransition(0, 0)
        }

    }
}
