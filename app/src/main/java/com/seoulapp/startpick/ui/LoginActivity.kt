package com.seoulapp.startpick.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.seoulapp.startpick.MainActivity
import com.seoulapp.startpick.R
import com.seoulapp.startpick.db.SharedPreferenceController
import com.seoulapp.startpick.network.ApplicationController
import com.seoulapp.startpick.network.NetworkService
import com.seoulapp.startpick.network.post.PostLoginResponse
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    var et_email: Boolean = false
    var et_pw: Boolean = false
    var login_btn_activation: Boolean = false

    var id = ""
    var pw = ""

    val networkService: NetworkService by lazy{
        ApplicationController.instance.networkService
    }

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
                postLoginResponse(id, pw)

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
                id = et_email_login_act.text.toString()
                SharedPreferenceController.MY_EMAIL = id

                //e-mail form
                val email_form = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$"

                //email폼에 맞게 썼는지
                if (id.matches(Regex(email_form))) {
                    et_email = true
                } else {
                    et_email = false
                }

                if (et_email) {
                    if (et_pw) {
                        login_btn_activation = true
                        btn_login_act.setBackgroundResource(R.drawable.sign_green_round_box)
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
                pw = et_password_login_act.text.toString()
                val pw_form = "((?=.*\\d)(?=.*[a-zA-Z]).{6,20})"

                if (pw.length >= 8 && pw.matches(Regex(pw_form))) {
                    et_pw = true
                } else {
                    et_pw = false
                }

                if (et_pw) {
                    if (et_email) {
                        login_btn_activation = true
                        btn_login_act.setBackgroundResource(R.drawable.sign_green_round_box)
                    }
                }
            }
        })
    }

    fun postLoginResponse(email :String, pw: String) {

        var jsonObject = JSONObject()
        jsonObject.put("email", email)
        jsonObject.put("pw", pw)

        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject
        var networkService = networkService.postlogin(gsonObject)
        networkService.enqueue(object : Callback<PostLoginResponse> {
            override fun onFailure(call: Call<PostLoginResponse>, t: Throwable) {
                Log.e("Login error", t.toString())
            }

            override fun onResponse(call: Call<PostLoginResponse>, response: Response<PostLoginResponse>) {
                if (response.isSuccessful) {
                    val status = response.body()!!.status
                    if (status == 200) {
                        //SharedPreferenceController.setUserToken(applicationContext, response.body()!!.data.token.token)
                        Log.e("로그인 성공",response.body()!!.status.toString())

                        SharedPreferenceController.USER_IDX = response.body()!!.data.userIdx
                        SharedPreferenceController.USER_NAME = response.body()!!.data.name
                        startActivity<MainActivity>()
                        finish()

                    } else if(status == 400){

                        //비밀번호가 다르거나, 유저 결과가 없을 때
                        Toast.makeText(getApplicationContext(), "잘못입력하셨습니다.", Toast.LENGTH_LONG).show()

                        Log.e("로그인 message",response.body()!!.message)
                    }
                }
            }
        })
    }
}

