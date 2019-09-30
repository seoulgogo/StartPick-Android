package com.seoulapp.startpick.ui

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.Toast
import com.seoulapp.startpick.R
import kotlinx.android.synthetic.main.activity_work_area.*
import kotlinx.android.synthetic.main.activity_work_area.back_arrow
import org.jetbrains.anko.ctx
import org.jetbrains.anko.textColor

class WorkAreaActivity : AppCompatActivity() {

    var isClickedArray : Array<Int> = Array(25, {0})
    var isActiveArray : Array<Boolean> = Array(25, {false})

    val green = "#22b573"
    val black = "#212529"
    var city_idx : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_area)

        back_arrow.setOnClickListener { finish() } // 뒤로가기 버튼 활성화
        WorkChangeColor() // 근무지역 필터 색깔 활성화
        AdaptActive() // 적용하기 버튼 세팅

    }


    /** 근무지역 필터 색깔 활성화 */
    fun WorkChangeColor(){
        tv_1.setOnClickListener {
            if(isClickedArray[0] % 2 == 0){
                city_idx = 1
                isActiveArray[0] = true
                tv_1.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_1.textColor = Color.parseColor(green)
                isClickedArray[0]++
                /* 눌려있는 것 클릭했을 때 */
            }else{
                isActiveArray[0]= false
                tv_1.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_1.textColor = Color.parseColor(black)
                isClickedArray[0]++
            }
            AdaptActive()
        }
        tv_2.setOnClickListener {
            if(isClickedArray[1] % 2 == 0){
                city_idx = 2
                isActiveArray[1] = true
                tv_2.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_2.textColor = Color.parseColor(green)
                isClickedArray[1]++
                /* 눌려있는 것 클릭했을 때 */
            }else{
                isActiveArray[1] = false
                tv_2.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_2.textColor = Color.parseColor(black)
                isClickedArray[1]++
            }
            AdaptActive()
        }
        tv_3.setOnClickListener {
            if(isClickedArray[2] % 2 == 0){
                city_idx = 3
                isActiveArray[2] = true
                tv_3.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_3.textColor = Color.parseColor(green)
                isClickedArray[2]++
            }else{
                isActiveArray[2] = false
                tv_3.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_3.textColor = Color.parseColor(black)
                isClickedArray[2]++
            }
            AdaptActive()
        }
        tv_4.setOnClickListener {
            if(isClickedArray[3] % 2 == 0){
                city_idx = 4
                isActiveArray[3] = true
                tv_4.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_4.textColor = Color.parseColor(green)
                isClickedArray[3]++
            }else{
                isActiveArray[3] = false
                tv_4.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_4.textColor = Color.parseColor(black)
                isClickedArray[3]++
            }
            AdaptActive()
        }
        tv_5.setOnClickListener {
            if(isClickedArray[4] % 2 == 0){
                city_idx = 5
                isActiveArray[4] = true
                tv_5.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_5.textColor = Color.parseColor(green)
                isClickedArray[4]++
            }else{
                isActiveArray[4] = false
                tv_5.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_5.textColor = Color.parseColor(black)
                isClickedArray[4]++
            }
            AdaptActive()
        }
        tv_6.setOnClickListener {
            if(isClickedArray[5] % 2 == 0){
                city_idx = 6
                isActiveArray[5] = true
                tv_6.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_6.textColor = Color.parseColor(green)
                isClickedArray[5]++
            }else{
                isActiveArray[5] = false
                tv_6.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_6.textColor = Color.parseColor(black)
                isClickedArray[5]++
            }
            AdaptActive()
        }
        tv_7.setOnClickListener {
            if(isClickedArray[6] % 2 == 0){
                city_idx = 7
                isActiveArray[6] = true
                tv_7.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_7.textColor = Color.parseColor(green)
                isClickedArray[6]++
            }else{
                isActiveArray[6] = false
                tv_7.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_7.textColor = Color.parseColor(black)
                isClickedArray[6]++
            }
            AdaptActive()
        }
        tv_8.setOnClickListener {
            if(isClickedArray[7] % 2 == 0){
                city_idx = 8
                isActiveArray[7] = true
                tv_8.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_8.textColor = Color.parseColor(green)
                isClickedArray[7]++
            }else{
                isActiveArray[7] = false
                tv_8.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_8.textColor = Color.parseColor(black)
                isClickedArray[7]++
            }
            AdaptActive()
        }
        tv_9.setOnClickListener {
            if(isClickedArray[8] % 2 == 0){
                city_idx = 9
                isActiveArray[8] = true
                tv_9.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_9.textColor = Color.parseColor(green)
                isClickedArray[8]++
            }else{
                isActiveArray[8] = false
                tv_9.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_9.textColor = Color.parseColor(black)
                isClickedArray[8]++
            }
            AdaptActive()
        }
        tv_10.setOnClickListener {
            if(isClickedArray[9] % 2 == 0){
                city_idx = 10
                isActiveArray[9] = true
                tv_10.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_10.textColor = Color.parseColor(green)
                isClickedArray[9]++
            }else{
                isActiveArray[9] = false
                tv_10.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_10.textColor = Color.parseColor(black)
                isClickedArray[9]++
            }
            AdaptActive()
        }
        tv_11.setOnClickListener {
            if(isClickedArray[10] % 2 == 0){
                city_idx = 11
                isActiveArray[10] = true
                tv_11.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_11.textColor = Color.parseColor(green)
                isClickedArray[10]++
            }else{
                isActiveArray[10] = false
                tv_11.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_11.textColor = Color.parseColor(black)
                isClickedArray[10]++
            }
            AdaptActive()
        }
        tv_12.setOnClickListener {
            if(isClickedArray[11] % 2 == 0){
                city_idx = 12
                isActiveArray[11] = true
                tv_12.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_12.textColor = Color.parseColor(green)
                isClickedArray[11]++
            }else{
                isActiveArray[11] = false
                tv_12.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_12.textColor = Color.parseColor(black)
                isClickedArray[11]++
            }
            AdaptActive()
        }
        tv_13.setOnClickListener {
            if(isClickedArray[12] % 2 == 0){
                city_idx = 13
                isActiveArray[12] = true
                tv_13.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_13.textColor = Color.parseColor(green)
                isClickedArray[12]++
            }else{
                isActiveArray[12] = false
                tv_13.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_13.textColor = Color.parseColor(black)
                isClickedArray[12]++
            }
            AdaptActive()
        }
        tv_14.setOnClickListener {
            if(isClickedArray[13] % 2 == 0){
                city_idx = 14
                isActiveArray[13] = true
                tv_14.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_14.textColor = Color.parseColor(green)
                isClickedArray[13]++
            }else{
                isActiveArray[13] = false
                tv_14.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_14.textColor = Color.parseColor(black)
                isClickedArray[13]++
            }
            AdaptActive()
        }
        tv_15.setOnClickListener {
            if(isClickedArray[14] % 2 == 0){
                city_idx = 15
                isActiveArray[14] = true
                tv_15.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_15.textColor = Color.parseColor(green)
                isClickedArray[14]++
            }else{
                isActiveArray[14] = false
                tv_15.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_15.textColor = Color.parseColor(black)
                isClickedArray[14]++
            }
            AdaptActive()
        }
        tv_16.setOnClickListener {
            if(isClickedArray[15] % 2 == 0){
                city_idx = 16
                isActiveArray[15] = true
                tv_16.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_16.textColor = Color.parseColor(green)
                isClickedArray[15]++
            }else{
                isActiveArray[15] = false
                tv_16.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_16.textColor = Color.parseColor(black)
                isClickedArray[15]++
            }
            AdaptActive()
        }
        tv_17.setOnClickListener {
            if(isClickedArray[16] % 2 == 0){
                city_idx = 17
                isActiveArray[16] = true
                tv_17.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_17.textColor = Color.parseColor(green)
                isClickedArray[16]++
            }else{
                isActiveArray[16] = false
                tv_17.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_17.textColor = Color.parseColor(black)
                isClickedArray[16]++
            }
            AdaptActive()
        }
        tv_18.setOnClickListener {
            if(isClickedArray[17] % 2 == 0){
                city_idx = 18
                isActiveArray[17] = true
                tv_18.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_18.textColor = Color.parseColor(green)
                isClickedArray[17]++
            }else{
                isActiveArray[17] = false
                tv_18.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_18.textColor = Color.parseColor(black)
                isClickedArray[17]++
            }
            AdaptActive()
        }
        tv_19.setOnClickListener {
            if(isClickedArray[18] % 2 == 0){
                city_idx = 19
                isActiveArray[18] = true
                tv_19.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_19.textColor = Color.parseColor(green)
                isClickedArray[18]++
            }else{
                isActiveArray[18] = false
                tv_19.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_19.textColor = Color.parseColor(black)
                isClickedArray[18]++
            }
            AdaptActive()
        }
        tv_20.setOnClickListener {
            if(isClickedArray[19] % 2 == 0){
                city_idx = 20
                isActiveArray[19] = true
                tv_20.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_20.textColor = Color.parseColor(green)
                isClickedArray[19]++
            }else{
                isActiveArray[19] = false
                tv_20.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_20.textColor = Color.parseColor(black)
                isClickedArray[19]++
            }
            AdaptActive()
        }
        tv_21.setOnClickListener {
            if(isClickedArray[20] % 2 == 0){
                city_idx = 21
                isActiveArray[20] = true
                tv_21.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_21.textColor = Color.parseColor(green)
                isClickedArray[20]++
            }else{
                isActiveArray[20] = false
                tv_21.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_21.textColor = Color.parseColor(black)
                isClickedArray[20]++
            }
            AdaptActive()
        }
        tv_22.setOnClickListener {
            if(isClickedArray[21] % 2 == 0){
                city_idx = 22
                isActiveArray[21] = true
                tv_22.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_22.textColor = Color.parseColor(green)
                isClickedArray[21]++
            }else{
                isActiveArray[21] = false
                tv_22.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_22.textColor = Color.parseColor(black)
                isClickedArray[21]++
            }
            AdaptActive()
        }
        tv_23.setOnClickListener {
            if(isClickedArray[22] % 2 == 0){
                city_idx = 23
                isActiveArray[22] = true
                tv_23.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_23.textColor = Color.parseColor(green)
                isClickedArray[22]++
            }else{
                isActiveArray[22] = false
                tv_23.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_23.textColor = Color.parseColor(black)
                isClickedArray[22]++
            }
            AdaptActive()
        }
        tv_24.setOnClickListener {
            if(isClickedArray[23] % 2 == 0){
                city_idx = 24
                isActiveArray[23] = true
                tv_24.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_24.textColor = Color.parseColor(green)
                isClickedArray[23]++
            }else{
                isActiveArray[23] = false
                tv_24.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_24.textColor = Color.parseColor(black)
                isClickedArray[23]++
            }
            AdaptActive()
        }
        tv_25.setOnClickListener {
            if(isClickedArray[24] % 2 == 0){
                city_idx = 25
                isActiveArray[24] = true
                tv_25.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_25.textColor = Color.parseColor(green)
                isClickedArray[24]++
            }else{
                isActiveArray[24] = false
                tv_25.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_25.textColor = Color.parseColor(black)
                isClickedArray[24]++
            }
            AdaptActive()
        }
    }

    /** 하나라도 눌리면 적용하기 버튼 활성화 */
    fun AdaptActive(){
        var activeOK = false
        var clickedCount : Int = 0
        for(i in 0..24){
            if(isClickedArray[i] == 1){
                clickedCount++;
                if(clickedCount > 1) {
                    Toast.makeText(ctx, "근무지역은 하나만 선택해주세요.", Toast.LENGTH_SHORT).show()
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
                intent.putExtra("city_idx", city_idx )
                setResult(RESULT_OK, intent)
                finish()
            }
        }else{
            btn_adapt.setOnClickListener {
                Toast.makeText(ctx, "근무지역을 선택해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }


}
