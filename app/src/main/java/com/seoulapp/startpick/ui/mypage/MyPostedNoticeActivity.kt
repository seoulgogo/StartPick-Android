package com.seoulapp.startpick.ui.mypage

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.seoulapp.startpick.R
import com.seoulapp.startpick.adapter.WithRecyAdapter
import kotlinx.android.synthetic.main.activity_my_postednotice.*


class MyPostedNoticeActivity : AppCompatActivity() {

    lateinit var jobViewTRecyclerviewAdpapter: WithRecyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_postednotice)

        setRecyclerView()
        setOnClickListener()

    }

    fun setOnClickListener() {
        img_back_btn_mypostednotice_act.setOnClickListener {
            finish()
        }
    }

    /* 리사이클러 뷰 설정 */
    fun setRecyclerView() {
        //var testDataList: ArrayList<WithItemData> = ArrayList()

//        testDataList.add(WithItemData("SNS 콘텐츠 크리에이터 1", "서울시창업지원센터", "콘텐츠"))
//        testDataList.add(WithItemData("SNS 콘텐츠 크리에이터 2", "서울시창업지원센터", "콘텐츠"))
//        testDataList.add(WithItemData("SNS 콘텐츠 크리에이터 3", "서울시창업지원센터", "콘텐츠"))
//        testDataList.add(WithItemData("SNS 콘텐츠 크리에이터 4", "서울시창업지원센터", "콘텐츠"))
//        testDataList.add(WithItemData("SNS 콘텐츠 크리에이터 5", "서울시창업지원센터", "콘텐츠"))
//        testDataList.add(WithItemData("SNS 콘텐츠 크리에이터 6", "서울시창업지원센터", "콘텐츠"))
//        testDataList.add(WithItemData("SNS 콘텐츠 크리에이터 7", "서울시창업지원센터", "콘텐츠"))
//        testDataList.add(WithItemData("SNS 콘텐츠 크리에이터 8", "서울시창업지원센터", "콘텐츠"))
//        testDataList.add(WithItemData("SNS 콘텐츠 크리에이터 9", "서울시창업지원센터", "콘텐츠"))

//        jobViewTRecyclerviewAdpapter = WithRecyAdapter(this, testDataList)
//        rv_my_postednotice_act.adapter = jobViewTRecyclerviewAdpapter
//        rv_my_postednotice_act.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }


}