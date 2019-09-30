package com.seoulapp.startpick.ui.mypage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulapp.startpick.R
import com.seoulapp.startpick.adapter.SupportAdapter
import com.seoulapp.startpick.adapter.WithRecyAdapter
import com.seoulapp.startpick.data.ApplicationData
import com.seoulapp.startpick.ui.adapter.ReceivedSupportAdapter
import com.seoulapp.startpick.data.ReceivedSupportData
import com.seoulapp.startpick.data.WithusItemData
import com.seoulapp.startpick.network.ApplicationController
import com.seoulapp.startpick.network.NetworkService
import com.seoulapp.startpick.network.get.GetSupportApplicationResponse
import com.seoulapp.startpick.network.get.GetSupportStatemyApplyResponse
import com.seoulapp.startpick.network.get.WithUs
import kotlinx.android.synthetic.main.fragment_mypage_scrap.*
import kotlinx.android.synthetic.main.fragment_mypage_support_state.*
import org.jetbrains.anko.textColorResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MypageSupportStateFragment : Fragment() {

    private lateinit var rootView: View

    lateinit var mypagesendRecyclerViewAdapter : WithRecyAdapter
    lateinit var mypageapplicationAdapter : ReceivedSupportAdapter

    var email = ""

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }


    var btn_selector_support = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(R.layout.fragment_mypage_support_state, container, false)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //email = SharedPreferenceController.MY_EMAIL
        email = "soso1@gmail.com"

      //  selector()
       // setOnClickListener()
        //setRecyclerView()
    }

//    fun setOnClickListener() {
//        btn_selector_support_myapge_support_fg.setOnClickListener {
//            btn_selector_support = false
//            selector()
//
//            //통신 recyclerview()나오도록
//            setRecyclerView()
//
//        }
//
//        btn_selector_business_myapge_support_fg.setOnClickListener {
//            btn_selector_support = true
//            selector()
//
//            //통신 recyclerview 통신
//            setRecyclerView()
//        }
//    }

//
//    //지원현황 보낸지원 뷰
//    private fun getSupportstateSendResponse() {
//
//        val getsupportstatesendResponse: Call<GetSupportStatemyApplyResponse> = networkService.getMyApply(email)
//
//        getsupportstatesendResponse.enqueue(object : Callback<GetSupportStatemyApplyResponse> {
//            override fun onFailure(call: Call<GetSupportStatemyApplyResponse>, t: Throwable) {
//                Log.e("스크랩 지원사업 fail", t.toString())
//            }
//
//            override fun onResponse(call: Call<GetSupportStatemyApplyResponse>, response: Response<GetSupportStatemyApplyResponse>) {
//                Log.e("스크랩 지원사업 success", response.body()!!.data.toString())
//                val temp: ArrayList<WithusItemData> = response.body()!!.data.withUsList
//                val status = response.body()!!.status
//
//                if (temp.size > 0) {
//                    if (status == 200) {
//
//                        mypagesendRecyclerViewAdapter = WithRecyAdapter(activity!!, temp)
//                        rv_mypage_support_state_fg.adapter = mypagesendRecyclerViewAdapter
//                        rv_mypage_support_state_fg.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
//
//
//                        mypagesendRecyclerViewAdapter.dataList.addAll(temp)
//                        mypagesendRecyclerViewAdapter.notifyDataSetChanged()
//
//                    }
//                } else{
//                    mypagesendRecyclerViewAdapter.dataList.clear()
//                }
//            }
//        })
//    }
//
//
//    //지원현황 받은지원 뷰
//    private fun getSupportstateapplicationResponse() {
//
//        val getsupportstatesendResponse: Call<GetSupportApplicationResponse> = networkService.getMypageApplication(email)
//
//        getsupportstatesendResponse.enqueue(object : Callback<GetSupportApplicationResponse> {
//            override fun onFailure(call: Call<GetSupportApplicationResponse>, t: Throwable) {
//                Log.e("스크랩 받은지원 fail", t.toString())
//            }
//
//            override fun onResponse(call: Call<GetSupportApplicationResponse>, response: Response<GetSupportApplicationResponse>) {
//                Log.e("스크랩 받은지원 success", response.body()!!.data.toString())
//                val temp: ArrayList<ApplicationData> = response.body()!!.data
//                val status = response.body()!!.status
//
//                if (temp.size > 0) {
//                    if (status == 200) {
//
//                        mypageapplicationAdapter = ReceivedSupportAdapter(activity!!, temp)
//                        rv_mypage_support_state_fg.adapter = mypageapplicationAdapter
//                        rv_mypage_support_state_fg.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
//
//
//                        mypageapplicationAdapter.dataList.addAll(temp)
//                        mypageapplicationAdapter.notifyDataSetChanged()
//
//                    }
//                } else{
//                    mypagesendRecyclerViewAdapter.dataList.clear()
//                }
//            }
//        })
//    }
//
//    //리사이클러뷰
//    fun setRecyclerView() {
//
//        if(btn_selector_support == false){
//
//            getSupportstateapplicationResponse()
//        }
//        else{
//            getSupportstateSendResponse()
//
//        }
//    }
//
//    fun selector() {
//        if (btn_selector_support) {
//            btn_selector_business_myapge_support_fg.setBackgroundResource(R.color.maincolor)
//            tv_selector_business_myapge_support_fg.textColorResource = R.color.white
//
//            btn_selector_support_myapge_support_fg.setBackgroundResource(R.drawable.mypage_scrap_selector_box)
//            tv_selector_support_myapge_support_fg.textColorResource = R.color.maincolor
//        } else {
//            btn_selector_business_myapge_support_fg.setBackgroundResource(R.drawable.mypage_scrap_selector_box)
//            tv_selector_business_myapge_support_fg.textColorResource = R.color.maincolor
//
//            btn_selector_support_myapge_support_fg.setBackgroundResource(R.color.maincolor)
//            tv_selector_support_myapge_support_fg.textColorResource = R.color.white
//        }
//    }


}
