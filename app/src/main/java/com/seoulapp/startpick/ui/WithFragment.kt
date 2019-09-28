package com.seoulapp.startpick.ui


import android.content.Intent
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
import com.seoulapp.startpick.data.WithusItemData
import com.seoulapp.startpick.network.ApplicationController
import com.seoulapp.startpick.network.NetworkService
import com.seoulapp.startpick.network.get.GetWithusAllResponse
import com.seoulapp.startpick.network.get.GetWithusFilterResponse
import kotlinx.android.synthetic.main.fragment_job.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WithFragment : Fragment() {

    private lateinit var rootView: View
    lateinit var withRecycleAdapter : WithRecyAdapter

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }
    
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

    /* NetworkService 파일에 정의한 함수 */
    private fun getWithFragmentResponse() {

        val getwithInfoResponse: Call<GetWithusAllResponse> = networkService.getWithList()

        getwithInfoResponse.enqueue(object : Callback<GetWithusAllResponse> {
            override fun onFailure(call: Call<GetWithusAllResponse>, t: Throwable) {
                Log.e("함께해요 리스트 all list fail", t.toString())
                Toast.makeText(context, "리스트를 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<GetWithusAllResponse>, response: Response<GetWithusAllResponse>) {
                val temp: ArrayList<WithusItemData> = response.body()!!.data
                val status = response.body()!!.status

                if (temp.size > 0) {
                    if (status == 200) {

                        val position = withRecycleAdapter.itemCount
                        withRecycleAdapter.dataList.addAll(temp)
                        withRecycleAdapter.notifyDataSetChanged()

                    }
                }
            }


        })
    }

//    /* NetworkService 파일에 정의한 함수 */
//    private fun getWithusFilterResponse() {
//
//        val getwithInfoResponse: Call<GetWithusFilterResponse> = networkService.getWithusDetailResponse()
//
//        getwithInfoResponse.enqueue(object : Callback<GetWithusFilterResponse> {
//            override fun onFailure(call: Call<GetWithusFilterResponse>, t: Throwable) {
//                Log.e("함께해요 리스트 all list fail", t.toString())
//                Toast.makeText(context, "리스트를 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onResponse(call: Call<GetWithusFilterResponse>, response: Response<GetWithusFilterResponse>) {
//                val temp: ArrayList<WithusItemData> = response.body()!!.data
//                val status = response.body()!!.status
//
//                if (temp.size > 0) {
//                    if (status == 200) {
//
//                        val position = withRecycleAdapter.itemCount
//                        withRecycleAdapter.dataList.addAll(temp)
//                        withRecycleAdapter.notifyDataSetChanged()
//
//                    }
//                }
//            }
//
//
//        })
//    }

    fun getFilterIntent(){

    }

    /* 리사이클러 뷰 설정 */
    fun setRecyclerView() {

        var withItemDataArray: ArrayList<WithusItemData> = ArrayList()

        withRecycleAdapter = WithRecyAdapter(activity!!, withItemDataArray)
        fragment_job_recyclerview.adapter = withRecycleAdapter
        fragment_job_recyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        getWithFragmentResponse()


    }

    /* 플로팅 이미지 설정 */
    fun floatingBtn() {
        // 글쓰기 버튼 클릭 리스너
        iv_write.setOnClickListener {
            var intent = Intent(this.context, WriteActivity::class.java)
            startActivity(intent)
        }
    }

    /* 필터 버튼 클릭 이벤트 */
    fun filterClick(){
        btn_filter.setOnClickListener {
            var intent = Intent(this.context, WithFilterActivity::class.java)
            startActivity(intent)
        }
    }


}


