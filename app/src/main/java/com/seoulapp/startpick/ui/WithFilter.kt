package com.seoulapp.startpick.ui

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.seoulapp.startpick.CommonFunction.CommonFunction
import com.seoulapp.startpick.R
import kotlinx.android.synthetic.main.activity_with_filter.*
import org.jetbrains.anko.textColor


class WithFilter : AppCompatActivity() {

    var isClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_filter)

        backBtn() // 뒤로가기 버튼 세팅
        //filterColorChange() // 필터 색깔 바꾸기

    }

    /* 뒤로가기 버튼 세팅 */
    fun backBtn() {
        back_arrow.setOnClickListener {
            finish()
            overridePendingTransition(0, 0)
        }
    }

    /* 필터 색 바꾸기 */
    fun filterColorChange(){
        val green = "#22b573"
        val black = "#212529"
        var isClickedArray : Array<Int> = Array(21, {0})
        //val changeTotal = CommonFunction()
        /* 전체 해야함 */
//        tv_1.setOnClickListener {
//            if(isClickedArray[0] % 2 == 0){
//                changeTotal.totalGreen(this)
//            }else{
//                val changeTotal = CommonFunction()
//                changeTotal.totalBlack(this)
//            }
//            isClickedArray[0]++
//        }
        tv_2.setOnClickListener {
                /* 안 눌려있는 것 클릭했을 때 */
            if(isClickedArray[1] % 2 == 0){
                tv_2.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_2.textColor = Color.parseColor(green)

                /* 눌려있는 것 클릭했을 때 */
            }else{
                tv_2.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_2.textColor = Color.parseColor(black)
            }
            isClickedArray[1]++
        }
        tv_3.setOnClickListener {
            /* 안 눌려있는 것 클릭했을 때 */
            if(isClickedArray[2] % 2 == 0){
                tv_3.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_3.textColor = Color.parseColor(green)

                /* 눌려있는 것 클릭했을 때 */
            }else{
                tv_3.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_3.textColor = Color.parseColor(black)
            }
            isClickedArray[2]++
        }
        tv_4.setOnClickListener {
            /* 안 눌려있는 것 클릭했을 때 */
            if(isClickedArray[3] % 2 == 0){
                tv_3.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_3.textColor = Color.parseColor(green)

                /* 눌려있는 것 클릭했을 때 */
            }else{
                tv_3.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_3.textColor = Color.parseColor(black)
            }
            isClickedArray[3]++
        }


    }



    
}
