package com.seoulapp.smartpick.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.seoulapp.smartpick.R
import com.seoulapp.smartpick.adapter.JobAdapter
import com.seoulapp.smartpick.data.JobData
import kotlinx.android.synthetic.main.fragment_job.*


class JobFragment : Fragment(), AdapterView.OnItemSelectedListener {

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

        setRecyclerView()
    }

    /* 스피너 관련 함수 */
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        // 선택되었을 때 이벤트 여기에 작성하기
    }

    /* 스피너 관련 함수 */
    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    /* 리사이클러 뷰 설정 */
    fun setRecyclerView() {
        var testDataList: ArrayList<JobData> = ArrayList()
        testDataList.add(JobData("SNS 콘텐츠 크리에이터 1", "서울시창업지원센터", "콘텐츠", "저희 회사는 모두가 의견을 자유롭게 내는 수평적인 조직 구조입니다."))
        testDataList.add(JobData("SNS 콘텐츠 크리에이터 2", "서울시창업지원센터", "콘텐츠", "저희 회사는 모두가 의견을 자유롭게 내는 수평적인 조직 구조입니다."))
        testDataList.add(JobData("SNS 콘텐츠 크리에이터 3", "서울시창업지원센터", "콘텐츠", "저희 회사는 모두가 의견을 자유롭게 내는 수평적인 조직 구조입니다."))
        testDataList.add(JobData("SNS 콘텐츠 크리에이터 4", "서울시창업지원센터", "콘텐츠", "저희 회사는 모두가 의견을 자유롭게 내는 수평적인 조직 구조입니다."))
        testDataList.add(JobData("SNS 콘텐츠 크리에이터 5", "서울시창업지원센터", "콘텐츠", "저희 회사는 모두가 의견을 자유롭게 내는 수평적인 조직 구조입니다."))
        testDataList.add(JobData("SNS 콘텐츠 크리에이터 6", "서울시창업지원센터", "콘텐츠", "저희 회사는 모두가 의견을 자유롭게 내는 수평적인 조직 구조입니다."))
        testDataList.add(JobData("SNS 콘텐츠 크리에이터 7", "서울시창업지원센터", "콘텐츠", "저희 회사는 모두가 의견을 자유롭게 내는 수평적인 조직 구조입니다."))
        testDataList.add(JobData("SNS 콘텐츠 크리에이터 8", "서울시창업지원센터", "콘텐츠", "저희 회사는 모두가 의견을 자유롭게 내는 수평적인 조직 구조입니다."))
        testDataList.add(JobData("SNS 콘텐츠 크리에이터 9", "서울시창업지원센터", "콘텐츠", "저희 회사는 모두가 의견을 자유롭게 내는 수평적인 조직 구조입니다."))
        testDataList.add(JobData("SNS 콘텐츠 크리에이터 10", "서울시창업지원센터", "콘텐츠", "저희 회사는 모두가 의견을 자유롭게 내는 수평적인 조직 구조입니다."))


        jobViewTestAdpapter = JobAdapter(activity!!, testDataList)
        fragment_job_recyclerview.adapter = jobViewTestAdpapter
        fragment_job_recyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)


    }

}
