package com.seoulapp.startpick.ui.mypage

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.seoulapp.startpick.R
import com.seoulapp.startpick.adapter.WithRecyAdapter
import com.seoulapp.startpick.data.WithusItemData
import com.seoulapp.startpick.db.SharedPreferenceController
import com.seoulapp.startpick.network.ApplicationController
import com.seoulapp.startpick.network.NetworkService
import com.seoulapp.startpick.network.get.GetWithusAllResponse
import kotlinx.android.synthetic.main.activity_my_postednotice.*
import org.jetbrains.anko.ctx
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MyPostedNoticeActivity : AppCompatActivity() {

    lateinit var jobViewTRecyclerviewAdpapter: WithRecyAdapter

    var user_idx = -1

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_postednotice)

        user_idx = SharedPreferenceController.USER_IDX

        setOnClickListener()
        getMypagegetMyWithus()

    }

    fun setOnClickListener() {
        img_back_btn_mypostednotice_act.setOnClickListener {
            finish()
        }
    }

    //내가올린공고
    private fun getMypagegetMyWithus() {

        val getMypagegetMyWithusResponse: Call<GetWithusAllResponse> = networkService.getMypagegetMyWithus(user_idx)

        getMypagegetMyWithusResponse.enqueue(object : Callback<GetWithusAllResponse> {
            override fun onFailure(call: Call<GetWithusAllResponse>, t: Throwable) {
                Log.e("스크랩 함께해요 fail", t.toString())
            }

            override fun onResponse(call: Call<GetWithusAllResponse>, response: Response<GetWithusAllResponse>) {
                Log.e("스크랩 함께해요 success", response.body()!!.data.toString())
                val temp: ArrayList<WithusItemData> = response.body()!!.data
                val status = response.body()!!.status

                if (temp.size > 0) {
                    if (status == 200) {
                        jobViewTRecyclerviewAdpapter = WithRecyAdapter(ctx, temp)
                        rv_my_postednotice_act.adapter = jobViewTRecyclerviewAdpapter
                        rv_my_postednotice_act.layoutManager = LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false)
                    }
                } else {
                }
            }
        })
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