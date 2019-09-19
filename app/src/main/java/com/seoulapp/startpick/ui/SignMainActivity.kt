package com.seoulapp.startpick.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.seoulapp.startpick.MainActivity
import com.seoulapp.startpick.R
import kotlinx.android.synthetic.main.activity_sign_main.*
import kotlinx.android.synthetic.main.fragment_map.*
import org.jetbrains.anko.startActivity

class SignMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_main)

        setOnClickListener()
    }

    fun setOnClickListener(){
        btn_intent_sign_up.setOnClickListener{
            startActivity<SignupActivity>()
        }

        btn_intent_login.setOnClickListener {
            startActivity<LoginActivity>()
        }
    }
}
