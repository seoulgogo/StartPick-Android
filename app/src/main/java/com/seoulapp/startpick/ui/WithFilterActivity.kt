package com.seoulapp.startpick.ui

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.Toast
import com.seoulapp.startpick.R
import kotlinx.android.synthetic.main.activity_with_filter.*
import kotlinx.android.synthetic.main.activity_with_filter.back_arrow
import kotlinx.android.synthetic.main.activity_with_filter.btn_adapt
import kotlinx.android.synthetic.main.activity_with_filter.tv_1
import kotlinx.android.synthetic.main.activity_with_filter.tv_10
import kotlinx.android.synthetic.main.activity_with_filter.tv_11
import kotlinx.android.synthetic.main.activity_with_filter.tv_12
import kotlinx.android.synthetic.main.activity_with_filter.tv_13
import kotlinx.android.synthetic.main.activity_with_filter.tv_14
import kotlinx.android.synthetic.main.activity_with_filter.tv_15
import kotlinx.android.synthetic.main.activity_with_filter.tv_16
import kotlinx.android.synthetic.main.activity_with_filter.tv_17
import kotlinx.android.synthetic.main.activity_with_filter.tv_18
import kotlinx.android.synthetic.main.activity_with_filter.tv_19
import kotlinx.android.synthetic.main.activity_with_filter.tv_2
import kotlinx.android.synthetic.main.activity_with_filter.tv_20
import kotlinx.android.synthetic.main.activity_with_filter.tv_21
import kotlinx.android.synthetic.main.activity_with_filter.tv_3
import kotlinx.android.synthetic.main.activity_with_filter.tv_4
import kotlinx.android.synthetic.main.activity_with_filter.tv_5
import kotlinx.android.synthetic.main.activity_with_filter.tv_6
import kotlinx.android.synthetic.main.activity_with_filter.tv_7
import kotlinx.android.synthetic.main.activity_with_filter.tv_8
import kotlinx.android.synthetic.main.activity_with_filter.tv_9
import org.jetbrains.anko.textColor


class WithFilterActivity : AppCompatActivity() {

    var isStartupClickedArray : Array<Int> = Array(21, {0})
    var isRoleClickedArray : Array<Int> = Array(8, {0})
    var startupSelect : Boolean = false
    var jobSelect : Boolean = false
    val green = "#22b573"
    val black = "#212529"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_filter)

        backBtn() // 뒤로가기 버튼 세팅
        StartupfilterColorChange() // 스타트업 분야 필터 색깔 세팅
        RolefilterColorChange() // 직무 필터 색깔 세팅
        initBtn() // 초기화 버튼 세팅


    }

    /********************
    * 여기서부터 함수들 *
    *********************/

    /** 뒤로가기 버튼 세팅 */
    fun backBtn() {
        back_arrow.setOnClickListener {
            finish()
        }
    }

    /** 필터 색 바꾸기
     *  배열 원소 값이 0이면 누르기 전 상태
     *  1이면 누른 후 상태
     *  */
    fun StartupfilterColorChange(){
        // 전체 선택
        tv_1.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[0]++
                tv_1.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_1.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[0] == 1){
                startupSelect = false
                isStartupClickedArray[0]--
                tv_1.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_1.textColor = Color.parseColor(black)
            }
            AdaptActive()
        }
        tv_2.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[1]++
                tv_2.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_2.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[1] == 1){
                startupSelect = false
                isStartupClickedArray[1]--
                tv_2.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_2.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        tv_3.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[2]++
                tv_3.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_3.textColor = Color.parseColor(green)
                // 눌려있던 필터를 선택하지 않고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[2] == 1){
                startupSelect = false
                isStartupClickedArray[2]--
                tv_3.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_3.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        tv_4.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[3]++
                tv_4.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_4.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[3] == 1){
                startupSelect = false
                isStartupClickedArray[3]--
                tv_4.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_4.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        tv_5.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[4]++
                tv_5.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_5.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[4] == 1){
                startupSelect = false
                isStartupClickedArray[4]--
                tv_5.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_5.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        tv_6.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[5]++
                tv_6.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_6.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[5] == 1){
                startupSelect = false
                isStartupClickedArray[5]--
                tv_6.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_6.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        tv_7.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[6]++
                tv_7.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_7.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[6] == 1){
                startupSelect = false
                isStartupClickedArray[6]--
                tv_7.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_7.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        tv_8.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[7]++
                tv_8.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_8.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[7] == 1){
                startupSelect = false
                isStartupClickedArray[7]--
                tv_8.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_8.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        tv_9.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[8]++
                tv_9.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_9.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[8] == 1){
                startupSelect = false
                isStartupClickedArray[8]--
                tv_9.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_9.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        tv_10.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[9]++
                tv_10.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_10.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[9] == 1){
                startupSelect = false
                isStartupClickedArray[9]--
                tv_10.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_10.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        tv_11.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[10]++
                tv_11.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_11.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[10] == 1){
                startupSelect = false
                isStartupClickedArray[10]--
                tv_11.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_11.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        tv_12.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[11]++
                tv_12.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_12.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[11] == 1){
                startupSelect = false
                isStartupClickedArray[11]--
                tv_12.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_12.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        tv_13.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[12]++
                tv_13.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_13.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[12] == 1){
                startupSelect = false
                isStartupClickedArray[12]--
                tv_13.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_13.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        tv_14.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[13]++
                tv_14.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_14.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[13] == 1){
                startupSelect = false
                isStartupClickedArray[13]--
                tv_14.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_14.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        tv_15.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[14]++
                tv_15.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_15.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[14] == 1){
                startupSelect = false
                isStartupClickedArray[14]--
                tv_15.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_15.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        tv_16.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[15]++
                tv_16.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_16.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[15] == 1){
                startupSelect = false
                isStartupClickedArray[15]--
                tv_16.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_16.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        tv_17.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[16]++
                tv_17.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_17.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[16] == 1){
                startupSelect = false
                isStartupClickedArray[16]--
                tv_17.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_17.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        tv_18.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[17]++
                tv_18.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_18.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[17] == 1){
                startupSelect = false
                isStartupClickedArray[17]--
                tv_18.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_18.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        tv_19.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[18]++
                tv_19.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_19.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[18] == 1){
                startupSelect = false
                isStartupClickedArray[18]--
                tv_19.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_19.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        tv_20.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[19]++
                tv_20.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_20.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[19] == 1){
                startupSelect = false
                isStartupClickedArray[19]--
                tv_20.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_20.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        tv_21.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(startupSelect == false){
                startupSelect = true
                isStartupClickedArray[20]++
                tv_21.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                tv_21.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(startupSelect == true && isStartupClickedArray[20] == 1){
                startupSelect = false
                isStartupClickedArray[20]--
                tv_21.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                tv_21.textColor = Color.parseColor(black)
            }else{
                if(isStartupClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "스타트업 분야는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }

    }

    /** 직무 필터 색 바꾸기 */
    fun RolefilterColorChange(){
        // 전체 선택
        role_1.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(jobSelect == false){
                jobSelect = true
                isRoleClickedArray[0]++
                role_1.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                role_1.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(jobSelect == true && isRoleClickedArray[0] == 1){
                jobSelect = false
                isRoleClickedArray[0]--
                role_1.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                role_1.textColor = Color.parseColor(black)
            }
            AdaptActive()
        }
        role_2.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(jobSelect == false){
                jobSelect = true
                isRoleClickedArray[1]++
                role_2.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                role_2.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(jobSelect == true && isRoleClickedArray[1] == 1){
                jobSelect = false
                isRoleClickedArray[1]--
                role_2.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                role_2.textColor = Color.parseColor(black)
            }else{
                if(isRoleClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "직무 필터는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        role_3.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(jobSelect == false){
                jobSelect = true
                isRoleClickedArray[2]++
                role_3.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                role_3.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(jobSelect == true && isRoleClickedArray[2] == 1){
                jobSelect = false
                isRoleClickedArray[2]--
                role_3.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                role_3.textColor = Color.parseColor(black)
            }else{
                if(isRoleClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "직무 필터는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        role_4.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(jobSelect == false){
                jobSelect = true
                isRoleClickedArray[3]++
                role_4.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                role_4.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(jobSelect == true && isRoleClickedArray[3] == 1){
                jobSelect = false
                isRoleClickedArray[3]--
                role_4.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                role_4.textColor = Color.parseColor(black)
            }else{
                if(isRoleClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "직무 필터는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        role_5.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(jobSelect == false){
                jobSelect = true
                isRoleClickedArray[4]++
                role_5.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                role_5.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(jobSelect == true && isRoleClickedArray[4] == 1){
                jobSelect = false
                isRoleClickedArray[4]--
                role_5.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                role_5.textColor = Color.parseColor(black)
            }else{
                if(isRoleClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "직무 필터는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        role_6.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(jobSelect == false){
                jobSelect = true
                isRoleClickedArray[5]++
                role_6.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                role_6.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(jobSelect == true && isRoleClickedArray[5] == 1){
                jobSelect = false
                isRoleClickedArray[5]--
                role_6.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                role_6.textColor = Color.parseColor(black)
            }else{
                if(isRoleClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "직무 필터는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        role_7.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(jobSelect == false){
                jobSelect = true
                isRoleClickedArray[6]++
                role_7.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                role_7.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(jobSelect == true && isRoleClickedArray[6] == 1){
                jobSelect = false
                isRoleClickedArray[6]--
                role_7.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                role_7.textColor = Color.parseColor(black)
            }else{
                if(isRoleClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "직무 필터는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
            AdaptActive()
        }
        role_8.setOnClickListener {
            // 모든 필터 중 처음 눌렀을 때
            if(jobSelect == false){
                jobSelect = true
                isRoleClickedArray[7]++
                role_8.background = ContextCompat.getDrawable(this, R.drawable.round_border_green)
                role_8.textColor = Color.parseColor(green)
                // 눌려있던 필터 선택을 해제하고 싶을 때
            }else if(jobSelect == true && isRoleClickedArray[7] == 1){
                jobSelect = false
                isRoleClickedArray[7]--
                role_8.background = ContextCompat.getDrawable(this, R.drawable.round_border_gray)
                role_8.textColor = Color.parseColor(black)
            }else{
                if(isRoleClickedArray[0] == 1){
                    Toast.makeText(this, "전체 필터를 해제해주세요.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "직무 필터는 하나만 선택할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
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
            for(i in 0..7){
                isRoleClickedArray[i] = 0
            }
            btn_adapt.setBackgroundResource(R.color.notAdapted)
            StartupTotalBlack(this)
            RoleTotalBlack(this)
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

    fun RoleTotalBlack(ctx : Context){
        role_1.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        role_1.textColor = Color.parseColor(black)
        role_2.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        role_2.textColor = Color.parseColor(black)
        role_3.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        role_3.textColor = Color.parseColor(black)
        role_4.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        role_4.textColor = Color.parseColor(black)
        role_5.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        role_5.textColor = Color.parseColor(black)
        role_6.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        role_6.textColor = Color.parseColor(black)
        role_7.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        role_7.textColor = Color.parseColor(black)
        role_8.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
        role_8.textColor = Color.parseColor(black)
    }


    /** 하나라도 눌리면 적용하기 버튼 활성화 */
    fun AdaptActive(){
        var StartupActiveOK = false
        var RoleActiveOK = false
        var startup_idx : Int = 0
        var job_idx : Int = 0
        
        for(i in 0..20){
            if(isStartupClickedArray[i] == 1){
                StartupActiveOK = true
                startup_idx = i
                break
            }else StartupActiveOK = false
        }
        for(i in 0..7){
            if(isRoleClickedArray[i] == 1){
                RoleActiveOK = true
                job_idx = i
                break
            }else RoleActiveOK = false
        }
        if(StartupActiveOK && RoleActiveOK) {
            btn_adapt.setBackgroundResource(R.color.maincolor)
            btn_adapt.setOnClickListener {
                // 필터 idx 넘겨주고 끝내기
                var intent = Intent()
                intent.putExtra("startup_idx", startup_idx )
                intent.putExtra("job_idx", job_idx )
                setResult(RESULT_OK, intent)
                finish()
            }
        }
        else {
            btn_adapt.setBackgroundResource(R.color.notAdapted)
            btn_adapt.setOnClickListener{
                Toast.makeText(this, "스타트업 분야와 직무 필터를 모두 선택해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
        

    }



    
}
