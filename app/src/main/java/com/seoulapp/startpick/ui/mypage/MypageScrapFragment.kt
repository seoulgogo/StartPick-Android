package com.seoulapp.startpick.ui.mypage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulapp.startpick.R
import com.seoulapp.startpick.adapter.JobAdapter
import com.seoulapp.startpick.data.JobData
import kotlinx.android.synthetic.main.fragment_job.*
import kotlinx.android.synthetic.main.fragment_mypage_scrap.*

class MypageScrapFragment : Fragment() {

    private lateinit var rootView: View
    lateinit var mypageScrapRecyclerViewAdapter : JobAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(R.layout.fragment_mypage_scrap, container, false)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setRecyclerView()
    }

    //리사이클러뷰
    fun setRecyclerView() {
        var mypageScrapData: ArrayList<JobData> = ArrayList()

        mypageScrapData.add(JobData("SNS 콘텐츠 크리에이터 1", "서울시창업지원센터", "콘텐츠"))
        mypageScrapData.add(JobData("SNS 콘텐츠 크리에이터 2", "서울시창업지원센터", "콘텐츠"))
        mypageScrapData.add(JobData("SNS 콘텐츠 크리에이터 3", "서울시창업지원센터", "콘텐츠"))
        mypageScrapData.add(JobData("SNS 콘텐츠 크리에이터 4", "서울시창업지원센터", "콘텐츠"))
        mypageScrapData.add(JobData("SNS 콘텐츠 크리에이터 5", "서울시창업지원센터", "콘텐츠"))
        mypageScrapData.add(JobData("SNS 콘텐츠 크리에이터 6", "서울시창업지원센터", "콘텐츠"))
        mypageScrapData.add(JobData("SNS 콘텐츠 크리에이터 7", "서울시창업지원센터", "콘텐츠"))
        mypageScrapData.add(JobData("SNS 콘텐츠 크리에이터 8", "서울시창업지원센터", "콘텐츠"))
        mypageScrapData.add(JobData("SNS 콘텐츠 크리에이터 9", "서울시창업지원센터", "콘텐츠"))

        mypageScrapRecyclerViewAdapter = JobAdapter(activity!!, mypageScrapData)
        rv_mypage_scrap_fg.adapter = mypageScrapRecyclerViewAdapter
        rv_mypage_scrap_fg.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

    }



}