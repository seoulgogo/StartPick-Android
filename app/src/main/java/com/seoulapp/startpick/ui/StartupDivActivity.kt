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
import kotlinx.android.synthetic.main.activity_startup_div.back_arrow
import kotlinx.android.synthetic.main.activity_startup_div.btn_adapt
import kotlinx.android.synthetic.main.activity_startup_div.tv_1
import kotlinx.android.synthetic.main.activity_startup_div.tv_10
import kotlinx.android.synthetic.main.activity_startup_div.tv_11
import kotlinx.android.synthetic.main.activity_startup_div.tv_12
import kotlinx.android.synthetic.main.activity_startup_div.tv_13
import kotlinx.android.synthetic.main.activity_startup_div.tv_14
import kotlinx.android.synthetic.main.activity_startup_div.tv_15
import kotlinx.android.synthetic.main.activity_startup_div.tv_16
import kotlinx.android.synthetic.main.activity_startup_div.tv_17
import kotlinx.android.synthetic.main.activity_startup_div.tv_18
import kotlinx.android.synthetic.main.activity_startup_div.tv_19
import kotlinx.android.synthetic.main.activity_startup_div.tv_2
import kotlinx.android.synthetic.main.activity_startup_div.tv_20
import kotlinx.android.synthetic.main.activity_startup_div.tv_21
import kotlinx.android.synthetic.main.activity_startup_div.tv_3
import kotlinx.android.synthetic.main.activity_startup_div.tv_4
import kotlinx.android.synthetic.main.activity_startup_div.tv_5
import kotlinx.android.synthetic.main.activity_startup_div.tv_6
import kotlinx.android.synthetic.main.activity_startup_div.tv_7
import kotlinx.android.synthetic.main.activity_startup_div.tv_8
import kotlinx.android.synthetic.main.activity_startup_div.tv_9
import kotlinx.android.synthetic.main.activity_work_area.*
import org.jetbrains.anko.ctx
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
    
    /** 스타트업 분야 필터 색깔 활성화 */
    fun StartupfilterColorChange(){
        tv_1.setOnClickListener {
            if(isStartupClickedArray[0] % 2 == 0){
                startup_idx = 0
                isStartupActiveArray[0] = true
                tv_1.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_1.textColor = Color.parseColor(green)
                isStartupClickedArray[0]++
                /* 눌려있는 것 클릭했을 때 */
            }else{
                isStartupActiveArray[0]= false
                tv_1.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_1.textColor = Color.parseColor(black)
                isStartupClickedArray[0]++
            }
            AdaptActive()
        }
        tv_2.setOnClickListener {
            if(isStartupClickedArray[1] % 2 == 0){
                startup_idx = 1
                isStartupActiveArray[1] = true
                tv_2.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_2.textColor = Color.parseColor(green)
                isStartupClickedArray[1]++
                /* 눌려있는 것 클릭했을 때 */
            }else{
                isStartupActiveArray[1] = false
                tv_2.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_2.textColor = Color.parseColor(black)
                isStartupClickedArray[1]++
            }
            AdaptActive()
        }
        tv_3.setOnClickListener {
            if(isStartupClickedArray[2] % 2 == 0){
                startup_idx = 2
                isStartupActiveArray[2] = true
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
            if(isStartupClickedArray[3] % 2 == 0){
                startup_idx = 3
                isStartupActiveArray[3] = true
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
            if(isStartupClickedArray[4] % 2 == 0){
                startup_idx = 4
                isStartupActiveArray[4] = true
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
            if(isStartupClickedArray[5] % 2 == 0){
                startup_idx = 5
                isStartupActiveArray[5] = true
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
            if(isStartupClickedArray[6] % 2 == 0){
                startup_idx = 6
                isStartupActiveArray[6] = true
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
            if(isStartupClickedArray[7] % 2 == 0){
                startup_idx = 7
                isStartupActiveArray[7] = true
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
            if(isStartupClickedArray[8] % 2 == 0){
                startup_idx = 8
                isStartupActiveArray[8] = true
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
            if(isStartupClickedArray[9] % 2 == 0){
                startup_idx = 9
                isStartupActiveArray[9] = true
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
            if(isStartupClickedArray[10] % 2 == 0){
                startup_idx = 10
                isStartupActiveArray[10] = true
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
            if(isStartupClickedArray[11] % 2 == 0){
                startup_idx = 11
                isStartupActiveArray[11] = true
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
            if(isStartupClickedArray[12] % 2 == 0){
                startup_idx = 12
                isStartupActiveArray[12] = true
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
            if(isStartupClickedArray[13] % 2 == 0){
                startup_idx = 13
                isStartupActiveArray[13] = true
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
            if(isStartupClickedArray[14] % 2 == 0){
                startup_idx = 14
                isStartupActiveArray[14] = true
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
            if(isStartupClickedArray[15] % 2 == 0){
                startup_idx = 15
                isStartupActiveArray[15] = true
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
            if(isStartupClickedArray[16] % 2 == 0){
                startup_idx = 16
                isStartupActiveArray[16] = true
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
            if(isStartupClickedArray[17] % 2 == 0){
                startup_idx = 17
                isStartupActiveArray[17] = true
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
            if(isStartupClickedArray[18] % 2 == 0){
                startup_idx = 18
                isStartupActiveArray[18] = true
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
            if(isStartupClickedArray[19] % 2 == 0){
                startup_idx = 19
                isStartupActiveArray[19] = true
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
            if(isStartupClickedArray[20] % 2 == 0){
                startup_idx = 20
                isStartupActiveArray[20] = true
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

    /** 하나라도 눌리면 적용하기 버튼 활성화 */
    fun AdaptActive(){
        var activeOK = false
        var clickedCount : Int = 0
        for(i in 0..20){
            if(isStartupClickedArray[i] == 1){
                clickedCount++;
                if(clickedCount > 1) {
                    Toast.makeText(ctx, "스타트업 분야는 하나만 선택해주세요.", Toast.LENGTH_SHORT).show()
                    btn_adapt.setBackgroundResource(R.color.notAdapted)
                    activeOK = false
                }else{
                    btn_adapt.setBackgroundResource(R.color.maincolor)
                    activeOK = true
                }
            }
        }

        // 적용하기 버튼 클릭 이벤트
        if(activeOK){
            btn_adapt.setOnClickListener {
                // 인텐트로 근무지역 idx 주기
                var intent = Intent()
                intent.putExtra("startup_idx", startup_idx )
                setResult(RESULT_OK, intent)
                finish()
            }
        }else{
            btn_adapt.setOnClickListener {
                Toast.makeText(ctx, "스타트업 분야를 선택해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
