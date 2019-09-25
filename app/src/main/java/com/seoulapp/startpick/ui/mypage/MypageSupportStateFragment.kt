package com.seoulapp.startpick.ui.mypage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulapp.startpick.R
import com.seoulapp.startpick.adapter.JobAdapter
import com.seoulapp.startpick.ui.adapter.ReceivedSupportAdapter
import com.seoulapp.startpick.data.JobData
import com.seoulapp.startpick.data.ReceivedSupportData
import kotlinx.android.synthetic.main.fragment_mypage_support_state.*
import org.jetbrains.anko.textColorResource

class MypageSupportStateFragment : Fragment() {

    private lateinit var rootView: View

    lateinit var mypageSupportRecyclerViewAdapter : JobAdapter
    lateinit var mypageSupportBusinessAdapter : ReceivedSupportAdapter


    var btn_selector_support = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(R.layout.fragment_mypage_support_state, container, false)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        selector()
        setOnClickListener()
        setRecyclerView()
    }

    fun setOnClickListener() {
        btn_selector_support_myapge_support_fg.setOnClickListener {
            btn_selector_support = false
            selector()

            //통신 recyclerview()나오도록
            setRecyclerView()

        }

        btn_selector_business_myapge_support_fg.setOnClickListener {
            btn_selector_support = true
            selector()

            //통신 recyclerview 통신
            setRecyclerView()
        }
    }

    //리사이클러뷰
    fun setRecyclerView() {

        if(btn_selector_support == false){
            var dataList: ArrayList<ReceivedSupportData> = ArrayList()
            dataList.add(ReceivedSupportData("2019년 사회적경제기업 스토어36.5 리뉴얼 지원사업 참여매장 모집 공고", "유가희"))
            dataList.add(ReceivedSupportData("2019년 사회적경제기업 스토어36.5 리뉴얼 지원사업 참여매장 모집 공고", "유가희"))
            dataList.add(ReceivedSupportData("2019년 사회적경제기업 스토어36.5 리뉴얼 지원사업 참여매장 모집 공고", "유가희"))
            dataList.add(ReceivedSupportData("2019년 사회적경제기업 스토어36.5 리뉴얼 지원사업 참여매장 모집 공고", "유가희"))
            dataList.add(ReceivedSupportData("2019년 사회적경제기업 스토어36.5 리뉴얼 지원사업 참여매장 모집 공고", "유가희"))
            dataList.add(ReceivedSupportData("2019년 사회적경제기업 스토어36.5 리뉴얼 지원사업 참여매장 모집 공고", "유가희"))
            dataList.add(ReceivedSupportData("2019년 사회적경제기업 스토어36.5 리뉴얼 지원사업 참여매장 모집 공고", "유가희"))
            dataList.add(ReceivedSupportData("2019년 사회적경제기업 스토어36.5 리뉴얼 지원사업 참여매장 모집 공고", "유가희"))
            dataList.add(ReceivedSupportData("2019년 사회적경제기업 스토어36.5 리뉴얼 지원사업 참여매장 모집 공고", "유가희"))
            dataList.add(ReceivedSupportData("2019년 사회적경제기업 스토어36.5 리뉴얼 지원사업 참여매장 모집 공고", "유가희"))


            mypageSupportBusinessAdapter = ReceivedSupportAdapter(activity!!, dataList)
            rv_mypage_support_state_fg.adapter = mypageSupportBusinessAdapter
            rv_mypage_support_state_fg.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        }
        else{

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

            mypageSupportRecyclerViewAdapter = JobAdapter(activity!!, mypageScrapData)
            rv_mypage_support_state_fg.adapter = mypageSupportRecyclerViewAdapter
            rv_mypage_support_state_fg.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        }
    }

    fun selector() {
        if (btn_selector_support) {
            btn_selector_business_myapge_support_fg.setBackgroundResource(R.color.maincolor)
            tv_selector_business_myapge_support_fg.textColorResource = R.color.white

            btn_selector_support_myapge_support_fg.setBackgroundResource(R.drawable.mypage_scrap_selector_box)
            tv_selector_support_myapge_support_fg.textColorResource = R.color.maincolor
        } else {
            btn_selector_business_myapge_support_fg.setBackgroundResource(R.drawable.mypage_scrap_selector_box)
            tv_selector_business_myapge_support_fg.textColorResource = R.color.maincolor

            btn_selector_support_myapge_support_fg.setBackgroundResource(R.color.maincolor)
            tv_selector_support_myapge_support_fg.textColorResource = R.color.white
        }
    }


}
