package com.seoulapp.startpick.ui

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.Toast
import com.seoulapp.startpick.R
import kotlinx.android.synthetic.main.activity_startup_div.*
import kotlinx.android.synthetic.main.activity_with_detail.*
import org.jetbrains.anko.textColor

class StartupDivActivity : AppCompatActivity() {

    var isStartupClickedArray : Array<Int> = Array(21, {0})
    var isStartupActiveArray : Array<Boolean> = Array(21, {false})
    val green = "#22b573"
    val black = "#212529"
    var startup_idx : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startup_div)

        backBtn() // 뒤로가기 버튼 세팅
        StartupfilterColorChange() // 스타트업 분야 필터 색깔 세팅
        initBtn() // 초기화 버튼 세팅
    }

    /** 뒤로가기 버튼 세팅 */
    fun backBtn() {
        back_arrow.setOnClickListener {
            finish()
        }
    }

    fun StartupfilterColorChange(){
        tv_1.setOnClickListener {
            if(isStartupClickedArray[0] % 2 == 0){
                StartupTotalGreen(this)
                startup_idx = 1
                // 다른 버튼 막기 위함
                for(i in 0..20){
                    isStartupClickedArray[i] = -1
                    isStartupActiveArray[i] = true
                }
            }
            else {
                StartupTotalBlack(this)
                for(i in 0..20){
                    isStartupClickedArray[i] = 0
                    isStartupActiveArray[i] = false
                }
            }
            AdaptActive()
        }
        tv_2.setOnClickListener {
            /* 안 눌려있는 것 클릭했을 때 */
            if(isStartupClickedArray[1] == -1){
                toastForUnchecked()
            }else if(isStartupClickedArray[1] % 2 == 0){
                isStartupActiveArray[1] = true
                startup_idx = 2
                tv_2.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_2.textColor = Color.parseColor(green)
                isStartupClickedArray[1]++
                /* 눌려있는 것 클릭했을 때 */
            }else {
                isStartupActiveArray[1] = false
                tv_2.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_2.textColor = Color.parseColor(black)
                isStartupClickedArray[1]++
            }
            AdaptActive()
        }
        tv_3.setOnClickListener {
            if(isStartupClickedArray[2] == -1) toastForUnchecked()
            else if(isStartupClickedArray[2] % 2 == 0){
                isStartupActiveArray[2] = true
                startup_idx = 3
                tv_3.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_3.textColor = Color.parseColor(green)
                isStartupClickedArray[2]++
            }else{
                isStartupActiveArray[2] = false
                tv_3.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_3.textColor = Color.parseColor(black)
                isStartupClickedArray[2]++
            }
            AdaptActive()
        }
        tv_4.setOnClickListener {
            if(isStartupClickedArray[3] == -1) toastForUnchecked()
            else if(isStartupClickedArray[3] % 2 == 0){
                isStartupActiveArray[3] = true
                startup_idx = 4
                tv_4.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_4.textColor = Color.parseColor(green)
                isStartupClickedArray[3]++
            }else{
                isStartupActiveArray[3] = false
                tv_4.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_4.textColor = Color.parseColor(black)
                isStartupClickedArray[3]++
            }
            AdaptActive()
        }
        tv_5.setOnClickListener {
            if(isStartupClickedArray[4] == -1) toastForUnchecked()
            else if(isStartupClickedArray[4] % 2 == 0){
                isStartupActiveArray[4] = true
                startup_idx = 5
                tv_5.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_5.textColor = Color.parseColor(green)
                isStartupClickedArray[4]++
            }else{
                isStartupActiveArray[4] = false
                tv_5.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_5.textColor = Color.parseColor(black)
                isStartupClickedArray[4]++
            }
            AdaptActive()
        }
        tv_6.setOnClickListener {
            if(isStartupClickedArray[5] == -1) toastForUnchecked()
            else if(isStartupClickedArray[5] % 2 == 0){
                isStartupActiveArray[5] = true
                startup_idx = 6
                tv_6.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_6.textColor = Color.parseColor(green)
                isStartupClickedArray[5]++
            }else{
                isStartupActiveArray[5] = false
                tv_6.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_6.textColor = Color.parseColor(black)
                isStartupClickedArray[5]++
            }
            AdaptActive()
        }
        tv_7.setOnClickListener {
            if(isStartupClickedArray[6] == -1) toastForUnchecked()
            else if(isStartupClickedArray[6] % 2 == 0){
                isStartupActiveArray[6] = true
                startup_idx = 7
                tv_7.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_7.textColor = Color.parseColor(green)
                isStartupClickedArray[6]++
            }else{
                isStartupActiveArray[6] = false
                tv_7.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_7.textColor = Color.parseColor(black)
                isStartupClickedArray[6]++
            }
            AdaptActive()
        }
        tv_8.setOnClickListener {
            if(isStartupClickedArray[7] == -1) toastForUnchecked()
            else if(isStartupClickedArray[7] % 2 == 0){
                isStartupActiveArray[7] = true
                startup_idx = 8
                tv_8.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_8.textColor = Color.parseColor(green)
                isStartupClickedArray[7]++
            }else{
                isStartupActiveArray[7] = false
                tv_8.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_8.textColor = Color.parseColor(black)
                isStartupClickedArray[7]++
            }
            AdaptActive()
        }
        tv_9.setOnClickListener {
            if(isStartupClickedArray[8] == -1) toastForUnchecked()
            else if(isStartupClickedArray[8] % 2 == 0){
                isStartupActiveArray[8] = true
                startup_idx = 9
                tv_9.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_9.textColor = Color.parseColor(green)
                isStartupClickedArray[8]++
            }else{
                isStartupActiveArray[8] = false
                tv_9.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_9.textColor = Color.parseColor(black)
                isStartupClickedArray[8]++
            }
            AdaptActive()
        }
        tv_10.setOnClickListener {
            if(isStartupClickedArray[9] == -1) toastForUnchecked()
            else if(isStartupClickedArray[9] % 2 == 0){
                isStartupActiveArray[9] = true
                startup_idx = 10
                tv_10.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_10.textColor = Color.parseColor(green)
                isStartupClickedArray[9]++
            }else{
                isStartupActiveArray[9] = false
                tv_10.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_10.textColor = Color.parseColor(black)
                isStartupClickedArray[9]++
            }
            AdaptActive()
        }
        tv_11.setOnClickListener {
            if(isStartupClickedArray[10] == -1) toastForUnchecked()
            else if(isStartupClickedArray[10] % 2 == 0){
                isStartupActiveArray[10] = true
                startup_idx = 11
                tv_11.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_11.textColor = Color.parseColor(green)
                isStartupClickedArray[10]++
            }else{
                isStartupActiveArray[10] = false
                tv_11.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_11.textColor = Color.parseColor(black)
                isStartupClickedArray[10]++
            }
            AdaptActive()
        }
        tv_12.setOnClickListener {
            if(isStartupClickedArray[11] == -1) toastForUnchecked()
            else if(isStartupClickedArray[11] % 2 == 0){
                isStartupActiveArray[11] = true
                startup_idx = 12
                tv_12.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_12.textColor = Color.parseColor(green)
                isStartupClickedArray[11]++
            }else{
                isStartupActiveArray[11] = false
                tv_12.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_12.textColor = Color.parseColor(black)
                isStartupClickedArray[11]++
            }
            AdaptActive()
        }
        tv_13.setOnClickListener {
            if(isStartupClickedArray[12] == -1) toastForUnchecked()
            else if(isStartupClickedArray[12] % 2 == 0){
                isStartupActiveArray[12] = true
                startup_idx = 13
                tv_13.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_13.textColor = Color.parseColor(green)
                isStartupClickedArray[12]++
            }else{
                isStartupActiveArray[12] = false
                tv_13.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_13.textColor = Color.parseColor(black)
                isStartupClickedArray[12]++
            }
            AdaptActive()
        }
        tv_14.setOnClickListener {
            if(isStartupClickedArray[13] == -1) toastForUnchecked()
            else if(isStartupClickedArray[13] % 2 == 0){
                isStartupActiveArray[13] = true
                startup_idx = 14
                tv_14.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_14.textColor = Color.parseColor(green)
                isStartupClickedArray[13]++
            }else{
                isStartupActiveArray[13] = false
                tv_14.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_14.textColor = Color.parseColor(black)
                isStartupClickedArray[13]++
            }
            AdaptActive()
        }
        tv_15.setOnClickListener {
            if(isStartupClickedArray[14] == -1) toastForUnchecked()
            else if(isStartupClickedArray[14] % 2 == 0){
                isStartupActiveArray[14] = true
                startup_idx = 15
                tv_15.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_15.textColor = Color.parseColor(green)
                isStartupClickedArray[14]++
            }else{
                isStartupActiveArray[14] = false
                tv_15.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_15.textColor = Color.parseColor(black)
                isStartupClickedArray[14]++
            }
            AdaptActive()
        }
        tv_16.setOnClickListener {
            if(isStartupClickedArray[15] == -1) toastForUnchecked()
            else if(isStartupClickedArray[15] % 2 == 0){
                isStartupActiveArray[15] = true
                startup_idx = 16
                tv_16.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_16.textColor = Color.parseColor(green)
                isStartupClickedArray[15]++
            }else{
                isStartupActiveArray[15] = false
                tv_16.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_16.textColor = Color.parseColor(black)
                isStartupClickedArray[15]++
            }
            AdaptActive()
        }
        tv_17.setOnClickListener {
            if(isStartupClickedArray[16] == -1) toastForUnchecked()
            else if(isStartupClickedArray[16] % 2 == 0){
                isStartupActiveArray[16] = true
                startup_idx = 17
                tv_17.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_17.textColor = Color.parseColor(green)
                isStartupClickedArray[16]++
            }else{
                isStartupActiveArray[16] = false
                tv_17.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_17.textColor = Color.parseColor(black)
                isStartupClickedArray[16]++
            }
            AdaptActive()
        }
        tv_18.setOnClickListener {
            if(isStartupClickedArray[17] == -1) toastForUnchecked()
            else if(isStartupClickedArray[17] % 2 == 0){
                isStartupActiveArray[17] = true
                startup_idx = 18
                tv_18.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_18.textColor = Color.parseColor(green)
                isStartupClickedArray[17]++
            }else{
                isStartupActiveArray[17] = false
                tv_18.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_18.textColor = Color.parseColor(black)
                isStartupClickedArray[17]++
            }
            AdaptActive()
        }
        tv_19.setOnClickListener {
            if(isStartupClickedArray[18] == -1) toastForUnchecked()
            else if(isStartupClickedArray[18] % 2 == 0){
                isStartupActiveArray[18] = true
                startup_idx = 19
                tv_19.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_19.textColor = Color.parseColor(green)
                isStartupClickedArray[18]++
            }else{
                isStartupActiveArray[18] = false
                tv_19.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_19.textColor = Color.parseColor(black)
                isStartupClickedArray[18]++
            }
            AdaptActive()
        }
        tv_20.setOnClickListener {
            if(isStartupClickedArray[19] == -1) toastForUnchecked()
            else if(isStartupClickedArray[19] % 2 == 0){
                isStartupActiveArray[19] = true
                startup_idx = 20
                tv_20.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_20.textColor = Color.parseColor(green)
                isStartupClickedArray[19]++
            }else{
                isStartupActiveArray[19] = false
                tv_20.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_20.textColor = Color.parseColor(black)
                isStartupClickedArray[19]++
            }
            AdaptActive()
        }
        tv_21.setOnClickListener {
            if(isStartupClickedArray[20] == -1) toastForUnchecked()
            else if(isStartupClickedArray[20] % 2 == 0){
                isStartupActiveArray[20] = true
                startup_idx = 21
                tv_21.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_21.textColor = Color.parseColor(green)
                isStartupClickedArray[20]++
            }else{
                isStartupActiveArray[20] = false
                tv_21.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_21.textColor = Color.parseColor(black)
                isStartupClickedArray[20]++
            }
            AdaptActive()
        }

    }

    /** 초기화 버튼 */
    fun initBtn(){
        btn_init.setOnClickListener {
            for(i in 0..20){
                isStartupClickedArray[i] = 0
            }
            btn_adapt.setBackgroundResource(R.color.notAdapted)
            StartupTotalBlack(this)
        }
    }

    /** 스타트업 전체 필터 클릭 시 색 바꾸기 */
    fun StartupTotalGreen(ctx : Context){
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

    fun StartupTotalBlack(ctx : Context){
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

    /** 토스트 메시지 */
    fun toastForUnchecked(){
        Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
    }

    /** 하나라도 눌리면 적용하기 버튼 활성화 */
    fun AdaptActive(){
        var StartupActiveOK = false

        for(i in 0..20){
            if(isStartupActiveArray[i]){
                StartupActiveOK = true
                break
            }else StartupActiveOK = false
        }
        if(StartupActiveOK) {
            btn_adapt.setBackgroundResource(R.color.maincolor)
            btn_adapt.setOnClickListener {
                var intent = Intent()
                intent.putExtra("startup_idx", startup_idx)
                setResult(RESULT_OK, intent)
                finish()
            }

        }
        else btn_adapt.setBackgroundResource(R.color.notAdapted)


    }
}
