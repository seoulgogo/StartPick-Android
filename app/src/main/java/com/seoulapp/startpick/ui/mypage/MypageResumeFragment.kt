package com.seoulapp.startpick.ui.mypage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulapp.startpick.R
import com.seoulapp.startpick.data.MapGetData
import com.seoulapp.startpick.ui.adapter.ReceivedSupportAdapter
import com.seoulapp.startpick.data.ReceivedSupportData
import com.seoulapp.startpick.data.ResumeData
import com.seoulapp.startpick.data.UserInfoData
import com.seoulapp.startpick.db.SharedPreferenceController
import com.seoulapp.startpick.network.ApplicationController
import com.seoulapp.startpick.network.NetworkService
import com.seoulapp.startpick.network.get.GetMypageUserInfoResponse
import com.seoulapp.startpick.network.get.GetShowAllResumeResponse
import com.seoulapp.startpick.ui.adapter.InfoMapAdapter
import com.seoulapp.startpick.ui.adapter.ResumeAdapter
import kotlinx.android.synthetic.main.fragment_map.*
import kotlinx.android.synthetic.main.fragment_mypage_resume.*
import kotlinx.android.synthetic.main.fragment_mypage_support_state.*
import org.jetbrains.anko.support.v4.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MypageResumeFragment : Fragment() {

    private lateinit var rootView: View

    lateinit var mypageSupportBusinessAdapter : ResumeAdapter

    var email  = ""

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(R.layout.fragment_mypage_resume, container, false)


        return rootView
    }

    override fun onResume() {
        super.onResume()

        getResumeAllShow(email)
        setRecyclerView()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //나중에 이걸로 바꿔야함
        email = SharedPreferenceController.MY_EMAIL

        //email = "soso1@gmail.com"

        setOnClickListener()
        getResumeAllShow(email)
        setRecyclerView()
    }


    //이력서 get함수
    private fun getResumeAllShow(email: String) {

        val getMypageResumeResponse: Call<GetShowAllResumeResponse> = networkService.getshowAllResume(email)

        getMypageResumeResponse.enqueue(object : Callback<GetShowAllResumeResponse> {

            override fun onFailure(call: Call<GetShowAllResumeResponse>, t: Throwable) {
                Log.e("이력서 frag get fail", t.toString())
            }

            override fun onResponse(call: Call<GetShowAllResumeResponse>, response: Response<GetShowAllResumeResponse>
            ) {
                Log.e("이력서 frag get success", response.body()!!.data.toString())


                val temp: ArrayList<ResumeData> = response.body()!!.data.resume
                val status = response.body()!!.status

                if (temp.size > 0) {
                    if (status == 200) {

                        var dataList: ArrayList<ResumeData> = temp


                        mypageSupportBusinessAdapter = ResumeAdapter(activity!!, dataList)
                        rv_mypage_resume_fg.adapter = mypageSupportBusinessAdapter
                        rv_mypage_resume_fg.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)


                    }
                }
            }
        })
    }


    fun setOnClickListener() {
        btn_write_resume_mypage_fg.setOnClickListener {
            startActivity<MyapageResumeActivity>()
        }
    }

    //리사이클러뷰
    fun setRecyclerView() {

        var dataList: ArrayList<ResumeData> = ArrayList()

        mypageSupportBusinessAdapter = ResumeAdapter(activity!!, dataList)
        rv_mypage_resume_fg.adapter = mypageSupportBusinessAdapter
        rv_mypage_resume_fg.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        //getResumeAllShow(email)
    }
}
