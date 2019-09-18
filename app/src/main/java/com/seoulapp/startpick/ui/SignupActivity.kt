package com.seoulapp.startpick.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.seoulapp.startpick.R
import com.isapanah.awesomespinner.AwesomeSpinner
import kotlinx.android.synthetic.main.activity_signup.view.*
import android.widget.ArrayAdapter






class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        spinner()
    }


    fun spinner() {

        var spinner = findViewById(R.id.awesomeSpinner_spinner) as AwesomeSpinner

        var spinnerArray = ArrayList<String>()
        spinnerArray.add("기획자")
        spinnerArray.add("개발자")
        spinnerArray.add("디자이너")
        spinnerArray.add("건축학자")

        val categoriesAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray)

        spinner.setAdapter(categoriesAdapter)

        spinner.setOnSpinnerItemClickListener(AwesomeSpinner.onSpinnerItemClickListener<String> { position, itemAtPosition ->
            //TODO YOUR ACTIONS
        })


    }
}

