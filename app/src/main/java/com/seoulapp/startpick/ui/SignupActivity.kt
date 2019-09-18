package com.seoulapp.startpick.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.seoulapp.startpick.R
import com.isapanah.awesomespinner.AwesomeSpinner
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_signup.*
import android.widget.Toast




class SignupActivity : AppCompatActivity() {

    var spinnerLTR:AwesomeSpinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        setOnClickListener()
        spinner()
        editText()
    }

    private fun editText() {
        et_email_signup_act.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })
    }

    fun spinner() {

        var spinner = findViewById(R.id.awesomeSpinner_spinner2) as AwesomeSpinner

        var spinnerArray = ArrayList<String>()
        spinnerArray.add("기획자")
        spinnerArray.add("개발자")
        spinnerArray.add("디자이너")
        spinnerArray.add("건축학자")

        val categoriesAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray)

        spinner.setAdapter(categoriesAdapter)

   /*     spinner.setOnSpinnerItemClickListener(AwesomeSpinner.onSpinnerItemClickListener<String> { position, itemAtPosition ->
            spinner.setSpinnerHint("alsdkfj")
        })
*/
        spinner.setOnSpinnerItemClickListener(
                AwesomeSpinner.onSpinnerItemClickListener {
                    position, itemAtPosition ->
                    Toast.makeText(applicationContext, "Position: " + position + " | Item: " + itemAtPosition + " | isSelected:" + spinner.isSelected(), Toast.LENGTH_LONG).show()
                })

    }

    fun setOnClickListener() {
        btn_back_signup_act.setOnClickListener {
            finish()
        }
    }

}

