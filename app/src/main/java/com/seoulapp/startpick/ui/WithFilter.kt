package com.seoulapp.startpick.ui

import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import com.seoulapp.startpick.R
import kotlinx.android.synthetic.main.activity_with_filter.*

class WithFilter : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_filter)

        backBtn() // 뒤로가기 버튼 세팅
        filterClick() // 필터 클릭시 효과 세팅
    }

    /* 뒤로가기 버튼 세팅 */
    fun backBtn() {
        back_arrow.setOnClickListener {
            finish()
            overridePendingTransition(0, 0)
        }
    }

    /* 필터 항목 클릭시 세팅 */
    fun filterClick(){
        val border: Drawable? = ResourcesCompat.getDrawable(resources, R.drawable.round_border, null)
        startup_total.background = border
    }
}
