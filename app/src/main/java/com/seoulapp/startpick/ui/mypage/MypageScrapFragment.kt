package com.seoulapp.startpick.ui.mypage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.seoulapp.startpick.R
import com.seoulapp.startpick.adapter.WithRecyAdapter
import com.seoulapp.startpick.adapter.SupportAdapter
import com.seoulapp.startpick.data.SupportItemData
import com.seoulapp.startpick.network.ApplicationController
import com.seoulapp.startpick.network.NetworkService
import com.seoulapp.startpick.network.get.GetSupportTabResponse
import kotlinx.android.synthetic.main.fragment_mypage_scrap.*
import org.jetbrains.anko.textColorResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MypageScrapFragment : Fragment() {

    private lateinit var rootView: View
    lateinit var mypageScrapRecyclerViewAdapter: WithRecyAdapter
    lateinit var mypageSupportBusinessAdapter: SupportAdapter

    var user_idx = -1

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    var btn_selector = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(R.layout.fragment_mypage_scrap, container, false)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        selector()
        setOnClickListener()
        setRecyclerView()
    }

    fun setOnClickListener() {
        btn_selector_business_myapge_scrap_fg.setOnClickListener {
            btn_selector = false
            selector()
            getSupportBussinessResponse()
            //통신 recyclerview()나오도록
            setRecyclerView()

        }

        btn_selector_job_myapge_scrap_fg.setOnClickListener {
            btn_selector = true
            selector()

            //통신 recyclerview 통신
            setRecyclerView()
        }
    }

    fun selector() {
        if (btn_selector) {
            btn_selector_job_myapge_scrap_fg.setBackgroundResource(R.color.maincolor)
            tv_selector_job_myapge_scrap_fg.textColorResource = R.color.white

            btn_selector_business_myapge_scrap_fg.setBackgroundResource(R.drawable.mypage_scrap_selector_box)
            tv_selector_business_myapge_scrap_fg.textColorResource = R.color.maincolor
        } else {
            btn_selector_job_myapge_scrap_fg.setBackgroundResource(R.drawable.mypage_scrap_selector_box)
            tv_selector_job_myapge_scrap_fg.textColorResource = R.color.maincolor

            btn_selector_business_myapge_scrap_fg.setBackgroundResource(R.color.maincolor)
            tv_selector_business_myapge_scrap_fg.textColorResource = R.color.white
        }
    }

    //스크랩 지원사업 뷰
    private fun getSupportBussinessResponse() {

        val getsupportbusinessResponse: Call<GetSupportTabResponse> = networkService.getScrapSupport(user_idx)

        getsupportbusinessResponse.enqueue(object : Callback<GetSupportTabResponse> {
            override fun onFailure(call: Call<GetSupportTabResponse>, t: Throwable) {
                Toast.makeText(context, "리스트를 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<GetSupportTabResponse>, response: Response<GetSupportTabResponse>) {
                val temp: ArrayList<SupportItemData> = response.body()!!.data
                val status = response.body()!!.status

                if (temp.size > 0) {
                    if (status == 200) {

                        mypageSupportBusinessAdapter = SupportAdapter(activity!!, temp)
                        rv_mypage_scrap_fg.adapter = mypageSupportBusinessAdapter
                        rv_mypage_scrap_fg.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

                        mypageSupportBusinessAdapter.dataList.addAll(temp)
                        mypageSupportBusinessAdapter.notifyDataSetChanged()

                    }
                }
            }
        })
    }


    //리사이클러뷰
    fun setRecyclerView() {

        if (btn_selector) {
//            var mypageScrapData: ArrayList<WithAdapter> = ArrayList()
//
//            mypageScrapData.add(WithAdapter("SNS 콘텐츠 크리에이터 1", "서울시창업지원센터", "콘텐츠"))
//            mypageScrapData.add(WithAdapter("SNS 콘텐츠 크리에이터 2", "서울시창업지원센터", "콘텐츠"))
//            mypageScrapData.add(WithAdapter("SNS 콘텐츠 크리에이터 3", "서울시창업지원센터", "콘텐츠"))
//            mypageScrapData.add(WithAdapter("SNS 콘텐츠 크리에이터 4", "서울시창업지원센터", "콘텐츠"))
//            mypageScrapData.add(WithAdapter("SNS 콘텐츠 크리에이터 5", "서울시창업지원센터", "콘텐츠"))
//            mypageScrapData.add(WithAdapter("SNS 콘텐츠 크리에이터 6", "서울시창업지원센터", "콘텐츠"))
//            mypageScrapData.add(WithAdapter("SNS 콘텐츠 크리에이터 7", "서울시창업지원센터", "콘텐츠"))
//            mypageScrapData.add(WithAdapter("SNS 콘텐츠 크리에이터 8", "서울시창업지원센터", "콘텐츠"))
//            mypageScrapData.add(WithAdapter("SNS 콘텐츠 크리에이터 9", "서울시창업지원센터", "콘텐츠"))

            //   mypageScrapRecyclerViewAdapter = WithRecyAdapter(activity!!, mypageScrapData)
//            rv_mypage_scrap_fg.adapter = mypageScrapRecyclerViewAdapter
//            rv_mypage_scrap_fg.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        } else {
            // var dataList: ArrayList<WithItemData> = ArrayList()
//            dataList.add(WithItemData("2019년 사회적경제기업 스토어36.5 리뉴얼 지원사업 참여매장 모집 공고", "고용노동부", "~19.09.09"))
//            dataList.add(WithItemData("2019년 사회적경제기업 스토어36.5 리뉴얼 지원사업 참여매장 모집 공고", "고용노동부", "~19.09.09"))
//            dataList.add(WithItemData("공고 1", "고용노동부", "~19.09.09"))
//            dataList.add(WithItemData("공고 2", "고용노동부", "~19.09.09"))
//            dataList.add(WithItemData("공고 3", "고용노동부", "~19.09.09"))
//            dataList.add(WithItemData("공고 4", "고용노동부", "~19.09.09"))
//            dataList.add(WithItemData("공고 5", "고용노동부", "~19.09.09"))
//            dataList.add(WithItemData("공고 6", "고용노동부", "~19.09.09"))
//            dataList.add(WithItemData("공고 7", "고용노동부", "~19.09.09"))
//            dataList.add(WithItemData("공고 8", "고용노동부", "~19.09.09"))


//            mypageSupportBusinessAdapter = SupportAdapter(activity!!, dataList)
//            rv_mypage_scrap_fg.adapter = mypageSupportBusinessAdapter
//            rv_mypage_scrap_fg.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        }
    }
}