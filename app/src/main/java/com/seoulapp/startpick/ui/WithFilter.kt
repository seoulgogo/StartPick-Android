package com.seoulapp.startpick.ui

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.Toast
import com.seoulapp.startpick.R
import kotlinx.android.synthetic.main.activity_with_filter.*
import org.jetbrains.anko.textColor


class WithFilter : AppCompatActivity() {

    var StartupChecked = false
    var RoleChecked = true // 바꿔야함 false로
    var isClickedArray : Array<Int> = Array(21, {0})


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_filter)

        backBtn() // 뒤로가기 버튼 세팅
        filterColorChange() // 필터 색깔 세팅
        isActive()
        activeAdaptBtn() // 적용하기 버튼 색깔 세팅


    }

    /********************
    * 여기서부터 함수들 *
    *********************/

    /** 뒤로가기 버튼 세팅 */
    fun backBtn() {
        back_arrow.setOnClickListener {
            finish()
            overridePendingTransition(0, 0)
        }
    }

    /** 필터 색 바꾸기 */
    fun filterColorChange(){
        val green = "#22b573"
        val black = "#212529"


        tv_1.setOnClickListener {
            if(isClickedArray[0] % 2 == 0){
                totalGreen(this)
                // 다른 버튼 막기 위함
                for(i in 0..20){
                    isClickedArray[i] = -1
                }
            }
            else {
                totalBlack(this)
                for(i in 0..20){
                    isClickedArray[i] = 0
                }
            }
        }
        tv_2.setOnClickListener {
                /* 안 눌려있는 것 클릭했을 때 */
            if(isClickedArray[1] == -1){
                toastForUnchecked()
            }else if(isClickedArray[1] % 2 == 0){
                tv_2.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_2.textColor = Color.parseColor(green)
                isClickedArray[1]++
                /* 눌려있는 것 클릭했을 때 */
            }else{
                tv_2.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_2.textColor = Color.parseColor(black)
                isClickedArray[1]++
            }

        }
        tv_3.setOnClickListener {
            if(isClickedArray[2] == -1) toastForUnchecked()
            else if(isClickedArray[2] % 2 == 0){
                tv_3.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_3.textColor = Color.parseColor(green)
                isClickedArray[2]++
            }else{
                tv_3.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_3.textColor = Color.parseColor(black)
                isClickedArray[2]++
            }
        }
        tv_4.setOnClickListener {
            if(isClickedArray[3] == -1) toastForUnchecked()
            else if(isClickedArray[3] % 2 == 0){
                tv_4.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_4.textColor = Color.parseColor(green)
                isClickedArray[3]++
            }else{
                tv_4.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_4.textColor = Color.parseColor(black)
                isClickedArray[3]++
            }
        }
        tv_5.setOnClickListener {
            if(isClickedArray[4] == -1) toastForUnchecked()
            else if(isClickedArray[4] % 2 == 0){
                tv_5.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_5.textColor = Color.parseColor(green)
                isClickedArray[4]++
            }else{
                tv_5.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_5.textColor = Color.parseColor(black)
                isClickedArray[4]++
            }
        }
        tv_6.setOnClickListener {
            if(isClickedArray[5] == -1) toastForUnchecked()
            else if(isClickedArray[5] % 2 == 0){
                tv_6.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_6.textColor = Color.parseColor(green)
                isClickedArray[5]++
            }else{
                tv_6.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_6.textColor = Color.parseColor(black)
                isClickedArray[5]++
            }
        }
        tv_7.setOnClickListener {
            if(isClickedArray[6] == -1) toastForUnchecked()
            else if(isClickedArray[6] % 2 == 0){
                tv_7.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_7.textColor = Color.parseColor(green)
                isClickedArray[6]++
            }else{
                tv_7.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_7.textColor = Color.parseColor(black)
                isClickedArray[6]++
            }
        }
        tv_8.setOnClickListener {
            if(isClickedArray[7] == -1) toastForUnchecked()
            else if(isClickedArray[7] % 2 == 0){
                tv_8.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_8.textColor = Color.parseColor(green)
                isClickedArray[7]++
            }else{
                tv_8.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_8.textColor = Color.parseColor(black)
                isClickedArray[7]++
            }
        }
        tv_9.setOnClickListener {
            if(isClickedArray[8] == -1) toastForUnchecked()
            else if(isClickedArray[8] % 2 == 0){
                tv_9.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_9.textColor = Color.parseColor(green)
                isClickedArray[8]++
            }else{
                tv_9.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_9.textColor = Color.parseColor(black)
                isClickedArray[8]++
            }
        }
        tv_10.setOnClickListener {
            if(isClickedArray[10] == -1) toastForUnchecked()
            else if(isClickedArray[9] % 2 == 0){
                tv_10.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_10.textColor = Color.parseColor(green)
                isClickedArray[9]++
            }else{
                tv_10.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_10.textColor = Color.parseColor(black)
                isClickedArray[9]++
            }
        }
        tv_11.setOnClickListener {
            if(isClickedArray[10] == -1) toastForUnchecked()
            else if(isClickedArray[10] % 2 == 0){
                tv_11.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_11.textColor = Color.parseColor(green)
                isClickedArray[10]++
            }else{
                tv_11.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_11.textColor = Color.parseColor(black)
                isClickedArray[10]++
            }
        }
        tv_12.setOnClickListener {
            if(isClickedArray[11] == -1) toastForUnchecked()
            else if(isClickedArray[11] % 2 == 0){
                tv_12.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_12.textColor = Color.parseColor(green)
                isClickedArray[11]++
            }else{
                tv_12.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_12.textColor = Color.parseColor(black)
                isClickedArray[11]++
            }
        }
        tv_13.setOnClickListener {
            if(isClickedArray[12] == -1) toastForUnchecked()
            else if(isClickedArray[12] % 2 == 0){
                tv_13.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_13.textColor = Color.parseColor(green)
                isClickedArray[12]++
            }else{
                tv_13.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_13.textColor = Color.parseColor(black)
                isClickedArray[12]++
            }
        }
        tv_14.setOnClickListener {
            if(isClickedArray[13] == -1) toastForUnchecked()
            else if(isClickedArray[13] % 2 == 0){
                tv_14.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_14.textColor = Color.parseColor(green)
                isClickedArray[13]++
            }else{
                tv_14.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_14.textColor = Color.parseColor(black)
                isClickedArray[13]++
            }
        }
        tv_15.setOnClickListener {
            if(isClickedArray[14] == -1) toastForUnchecked()
            else if(isClickedArray[14] % 2 == 0){
                tv_15.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_15.textColor = Color.parseColor(green)
                isClickedArray[14]++
            }else{
                tv_15.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_15.textColor = Color.parseColor(black)
                isClickedArray[14]++
            }
        }
        tv_16.setOnClickListener {
            if(isClickedArray[15] == -1) toastForUnchecked()
            else if(isClickedArray[15] % 2 == 0){
                tv_16.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_16.textColor = Color.parseColor(green)
                isClickedArray[15]++
            }else{
                tv_16.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_16.textColor = Color.parseColor(black)
                isClickedArray[15]++
            }
        }
        tv_17.setOnClickListener {
            if(isClickedArray[16] == -1) toastForUnchecked()
            else if(isClickedArray[16] % 2 == 0){
                tv_17.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_17.textColor = Color.parseColor(green)
                isClickedArray[16]++
            }else{
                tv_17.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_17.textColor = Color.parseColor(black)
                isClickedArray[16]++
            }
        }
        tv_18.setOnClickListener {
            if(isClickedArray[17] == -1) toastForUnchecked()
            else if(isClickedArray[17] % 2 == 0){
                tv_18.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_18.textColor = Color.parseColor(green)
                isClickedArray[17]++
            }else{
                tv_18.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_18.textColor = Color.parseColor(black)
                isClickedArray[17]++
            }
        }
        tv_19.setOnClickListener {
            if(isClickedArray[18] == -1) toastForUnchecked()
            else if(isClickedArray[18] % 2 == 0){
                tv_19.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_19.textColor = Color.parseColor(green)
                isClickedArray[18]++
            }else{
                tv_19.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_19.textColor = Color.parseColor(black)
                isClickedArray[18]++
            }
        }
        tv_20.setOnClickListener {
            if(isClickedArray[19] == -1) toastForUnchecked()
            else if(isClickedArray[19] % 2 == 0){
                tv_20.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_20.textColor = Color.parseColor(green)
                isClickedArray[19]++
            }else{
                tv_20.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_20.textColor = Color.parseColor(black)
                isClickedArray[19]++
            }
        }
        tv_21.setOnClickListener {
            if(isClickedArray[20] == -1) toastForUnchecked()
            else if(isClickedArray[20] % 2 == 0){
                tv_21.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_21.textColor = Color.parseColor(green)
                isClickedArray[20]++
            }else{
                tv_21.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_21.textColor = Color.parseColor(black)
                isClickedArray[20]++
            }
        }
    }



    /** 전체 필터 클릭 시 색 바꾸기 */
    fun totalGreen(ctx : Context){
        val green = "#22b573"
        tv_1.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_1.textColor = Color.parseColor(green)
        tv_2.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_2.textColor = Color.parseColor(green)
        tv_3.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_3.textColor = Color.parseColor(green)
        tv_4.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_4.textColor = Color.parseColor(green)
        tv_5.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_5.textColor = Color.parseColor(green)
        tv_6.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_6.textColor = Color.parseColor(green)
        tv_7.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_7.textColor = Color.parseColor(green)
        tv_8.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_8.textColor = Color.parseColor(green)
        tv_9.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_9.textColor = Color.parseColor(green)
        tv_10.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_10.textColor = Color.parseColor(green)
        tv_11.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_11.textColor = Color.parseColor(green)
        tv_12.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_12.textColor = Color.parseColor(green)
        tv_13.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_13.textColor = Color.parseColor(green)
        tv_14.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_14.textColor = Color.parseColor(green)
        tv_15.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_15.textColor = Color.parseColor(green)
        tv_16.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_16.textColor = Color.parseColor(green)
        tv_17.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_17.textColor = Color.parseColor(green)
        tv_18.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_18.textColor = Color.parseColor(green)
        tv_19.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_19.textColor = Color.parseColor(green)
        tv_20.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_20.textColor = Color.parseColor(green)
        tv_21.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
        tv_21.textColor = Color.parseColor(green)
    }

    fun totalBlack(ctx : Context){
        val black = "#212529"
        tv_1.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_1.textColor = Color.parseColor(black)
        tv_2.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_2.textColor = Color.parseColor(black)
        tv_3.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_3.textColor = Color.parseColor(black)
        tv_4.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_4.textColor = Color.parseColor(black)
        tv_5.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_5.textColor = Color.parseColor(black)
        tv_6.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_6.textColor = Color.parseColor(black)
        tv_7.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_7.textColor = Color.parseColor(black)
        tv_8.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_8.textColor = Color.parseColor(black)
        tv_9.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_9.textColor = Color.parseColor(black)
        tv_10.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_10.textColor = Color.parseColor(black)
        tv_11.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_11.textColor = Color.parseColor(black)
        tv_12.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_12.textColor = Color.parseColor(black)
        tv_13.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_13.textColor = Color.parseColor(black)
        tv_14.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_14.textColor = Color.parseColor(black)
        tv_15.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_15.textColor = Color.parseColor(black)
        tv_16.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_16.textColor = Color.parseColor(black)
        tv_17.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_17.textColor = Color.parseColor(black)
        tv_18.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_18.textColor = Color.parseColor(black)
        tv_19.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_19.textColor = Color.parseColor(black)
        tv_20.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_20.textColor = Color.parseColor(black)
        tv_21.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        tv_21.textColor = Color.parseColor(black)
    }

    /** 토스트 */
    fun toastForUnchecked(){
        Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
    }

    /** 적용하기 버튼 활성화 */
    fun activeAdaptBtn(){
        val green = "#22b573"
        if(StartupChecked && RoleChecked){
            Toast.makeText(this, "안냥", Toast.LENGTH_SHORT).show()
           // btn_adapt.setBackgroundColor(Color.parseColor(green))
        }
    }

    fun isActive(){
        for(i in 0..20){
            if(isClickedArray[i] != 0) StartupChecked = true
        }
    }

    
}
