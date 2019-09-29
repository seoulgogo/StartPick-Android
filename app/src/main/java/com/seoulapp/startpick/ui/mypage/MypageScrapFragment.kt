package com.seoulapp.startpick.ui.mypage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulapp.startpick.R
import com.seoulapp.startpick.adapter.WithRecyAdapter
import com.seoulapp.startpick.adapter.SupportAdapter
import com.seoulapp.startpick.data.SupportItemData
import com.seoulapp.startpick.data.WithusItemData
import com.seoulapp.startpick.network.ApplicationController
import com.seoulapp.startpick.network.NetworkService
import com.seoulapp.startpick.network.get.GetSupportTabResponse
import com.seoulapp.startpick.network.get.GetWithusAllResponse
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

        //이걸로 나중에 바꿔야함
        //user_idx = SharedPreferenceController.USER_IDX

        user_idx = 1

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
            setRecyclerView()

        }

        btn_selector_job_myapge_scrap_fg.setOnClickListener {
            btn_selector = true
            selector()
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
                Log.e("스크랩 지원사업 fail", t.toString())
            }

            override fun onResponse(call: Call<GetSupportTabResponse>, response: Response<GetSupportTabResponse>) {
                Log.e("스크랩 지원사업 success", response.body()!!.data.toString())
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
                } else{
                  mypageScrapRecyclerViewAdapter.dataList.clear()
                }
            }
        })
    }

    //스크랩 함께해요 뷰
    private fun getSupportWithUsResponse() {

        val getwithusResponse: Call<GetWithusAllResponse> = networkService.getScrapWithUs(user_idx)

        getwithusResponse.enqueue(object : Callback<GetWithusAllResponse> {
            override fun onFailure(call: Call<GetWithusAllResponse>, t: Throwable) {
                Log.e("스크랩 함께해요 fail", t.toString())
            }

            override fun onResponse(call: Call<GetWithusAllResponse>, response: Response<GetWithusAllResponse>) {
                Log.e("스크랩 함께해요 success", response.body()!!.data.toString())
                val temp: ArrayList<WithusItemData> = response.body()!!.data
                val status = response.body()!!.status

                if (temp.size > 0) {
                    if (status == 200) {

                        mypageScrapRecyclerViewAdapter.dataList.addAll(temp)
                        mypageScrapRecyclerViewAdapter.notifyDataSetChanged()

                    }
                }
                else{
                    mypageScrapRecyclerViewAdapter.dataList.clear()
                }
            }
        })
    }

    //리사이클러뷰
    fun setRecyclerView() {

        if (btn_selector) {
            val dataList: ArrayList<WithusItemData> = ArrayList()

            mypageScrapRecyclerViewAdapter = WithRecyAdapter(activity!!, dataList)
            rv_mypage_scrap_fg.adapter = mypageScrapRecyclerViewAdapter
            rv_mypage_scrap_fg.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

            getSupportWithUsResponse()
        } else {
            getSupportBussinessResponse()
        }
    }
}