package com.seoulapp.startpick.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.seoulapp.startpick.MainActivity
import com.seoulapp.startpick.R
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

    var et_email: Boolean = false
    var et_pw: Boolean = false
    var login_btn_activation: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editText()
        setOnClickListener()
    }

    private fun setOnClickListener() {

        btn_login_act.setOnClickListener {

            if(login_btn_activation)
            {
                //##통신
                finish()
                startActivity<MainActivity>()
            }else
            {
                var text = ""
                if (!et_email)
                    text = "이메일"
                else if (!et_pw)
                    text = "비밀번호"
                Toast.makeText(getApplicationContext(), text + "의 입력이 잘못 되었습니다.", Toast.LENGTH_LONG).show()
            }
        }

        btn_back_login_act.setOnClickListener {
            finish()
        }
    }

    private fun editText() {

        //이메일
        et_email_login_act.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val text = et_email_login_act.text
                //e-mail form
                val email_form = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$"

                //email폼에 맞게 썼는지
                if (text.matches(Regex(email_form))) {
                    et_email = true
                } else {
                    et_email = false
                }

                if (et_email) {
                    if (et_pw) {
                        login_btn_activation = true
                        btn_login_act.setBackgroundResource(R.color.maincolor)
                    }
                }
            }
        })

        //비밀번호
        et_password_login_act.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val text = et_password_login_act.text.toString()
                val pw_form = "((?=.*\\d)(?=.*[a-zA-Z]).{6,20})"

                if (text.length >= 8 && text.matches(Regex(pw_form))) {
                    et_pw = true
                } else {
                    et_pw = false
                }

                if (et_pw) {
                    if (et_email) {
                        login_btn_activation = true
                        btn_login_act.setBackgroundResource(R.color.maincolor)
                    }
                }
            }
        })
    }
}

