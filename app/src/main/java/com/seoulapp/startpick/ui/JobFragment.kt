package com.seoulapp.startpick.ui


import android.content.Intent
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


class JobFragment : Fragment() {

    private lateinit var rootView: View
    lateinit var jobViewTestAdpapter : JobAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_job, container, false)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setRecyclerView() // 리사이클러뷰 데이터 세팅
        floatingBtn() // 글쓰기 버튼 세팅
        filterClick() // 필터 버튼 세팅
    }

    /* 리사이클러 뷰 설정 */
    fun setRecyclerView() {
        var testDataList: ArrayList<JobData> = ArrayList()

        testDataList.add(JobData("SNS 콘텐츠 크리에이터 1", "서울시창업지원센터", "콘텐츠"))
        testDataList.add(JobData("SNS 콘텐츠 크리에이터 2", "서울시창업지원센터", "콘텐츠"))
        testDataList.add(JobData("SNS 콘텐츠 크리에이터 3", "서울시창업지원센터", "콘텐츠"))
        testDataList.add(JobData("SNS 콘텐츠 크리에이터 4", "서울시창업지원센터", "콘텐츠"))
        testDataList.add(JobData("SNS 콘텐츠 크리에이터 5", "서울시창업지원센터", "콘텐츠"))
        testDataList.add(JobData("SNS 콘텐츠 크리에이터 6", "서울시창업지원센터", "콘텐츠"))
        testDataList.add(JobData("SNS 콘텐츠 크리에이터 7", "서울시창업지원센터", "콘텐츠"))
        testDataList.add(JobData("SNS 콘텐츠 크리에이터 8", "서울시창업지원센터", "콘텐츠"))
        testDataList.add(JobData("SNS 콘텐츠 크리에이터 9", "서울시창업지원센터", "콘텐츠"))

        jobViewTestAdpapter = JobAdapter(activity!!, testDataList)
        fragment_job_recyclerview.adapter = jobViewTestAdpapter
        fragment_job_recyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

    }

    /* 플로팅 이미지 설정 */
    fun floatingBtn() {
        // 글쓰기 버튼 클릭 리스너
        iv_write.setOnClickListener {
            var intent = Intent(this.context, WriteActivity::class.java)
            startActivity(intent)
        }
    }

    fun filterClick(){
        btn_filter.setOnClickListener {
            var intent = Intent(this.context, WithFilter::class.java)
            startActivity(intent)
        }
    }
}
