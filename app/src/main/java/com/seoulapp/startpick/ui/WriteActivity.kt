package com.seoulapp.startpick.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.isapanah.awesomespinner.AwesomeSpinner
import com.seoulapp.startpick.R
import kotlinx.android.synthetic.main.activity_write.*

class WriteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        /* 뒤로가기 */
        back_arrow.setOnClickListener {
            finish()
            overridePendingTransition(0, 0)
        }

        /* 근무지역 필터 클릭시 화면 전환 */
        btn_worearea.setOnClickListener {
            var intent = Intent(this, WorkAreaActivity::class.java)
            startActivity(intent)
        }

        btn_company.setOnClickListener {
            var intent = Intent(this, StartupDivActivity::class.java)
            startActivity(intent)
        }

        JobSpinner()
        PersonSpinner()


    }

    /** 스피너 호출 함수 */
    fun JobSpinner() {

        var spinner = findViewById(R.id.selectJob) as AwesomeSpinner

        var spinnerArray = ArrayList<String>()
        spinnerArray.add("개발")
        spinnerArray.add("기획")
        spinnerArray.add("디자인")
        spinnerArray.add("마케팅")
        spinnerArray.add("미디어")
        spinnerArray.add("영업")
        spinnerArray.add("기타")

        val categoriesAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray)

        spinner.setAdapter(categoriesAdapter)
        spinner.setOnSpinnerItemClickListener(
                AwesomeSpinner.onSpinnerItemClickListener { position, itemAtPosition ->
                })
    }

    fun PersonSpinner() {

        var spinner = findViewById(R.id.selectPerson) as AwesomeSpinner

        var spinnerArray = ArrayList<String>()
        spinnerArray.add("1명")
        spinnerArray.add("2명")
        spinnerArray.add("3명")
        spinnerArray.add("4명")
        spinnerArray.add("5명")
        spinnerArray.add("미정")

        val categoriesAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray)

        spinner.setAdapter(categoriesAdapter)
        spinner.setOnSpinnerItemClickListener(
                AwesomeSpinner.onSpinnerItemClickListener { position, itemAtPosition ->
                })
    }


}
