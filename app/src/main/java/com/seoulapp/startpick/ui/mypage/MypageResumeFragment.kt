package com.seoulapp.startpick.ui.mypage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulapp.startpick.R
import com.seoulapp.startpick.ui.SignupActivity
import kotlinx.android.synthetic.main.fragment_mypage_resume.*
import org.jetbrains.anko.support.v4.startActivity

class MypageResumeFragment : Fragment() {

    private lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(R.layout.fragment_mypage_resume, container, false)



        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setOnClickListener()
    }

    fun setOnClickListener(){
        btn_write_resume_mypage_fg.setOnClickListener {
            startActivity<MyapageResumeActivity>()
        }
    }

}