package com.seoulapp.startpick.ui.mypage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.seoulapp.startpick.R
import kotlinx.android.synthetic.main.activity_myapage_resume.*

class MyapageResumeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myapage_resume)

        setOnClickListener()
    }

    fun setOnClickListener(){
        btn_back_mypage_resume_act.setOnClickListener{
            finish()
        }
    }
}
