package com.seoulapp.startpick.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.seoulapp.startpick.R
import com.seoulapp.startpick.data.SupportDetailData
import com.seoulapp.startpick.network.ApplicationController
import com.seoulapp.startpick.network.NetworkService
import com.seoulapp.startpick.network.get.GetSupportDetailResponse
import kotlinx.android.synthetic.main.activity_support_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response




class SupportDetailActivity : AppCompatActivity() {

    var business_idx : Int = 0
    var link : String = ""
    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_support_detail)

        /** 이 엑티비티에서 실행되는 기능들 */
        back_arrow.setOnClickListener { finish() } // 뒤로가기 버튼
        getIntentData() // intent 로 보낸 데이터 받기
        getSupportDetailResponse() // 지원사업 디테일 데이터 통신
        btnLookDetail() // 상세보기 버튼 세팅
        /************************************/
    }

    /* NetworkService 파일에 정의한 함수 */
    private fun getSupportDetailResponse() {

        val getwithInfoResponse: Call<GetSupportDetailResponse> = networkService.getSupportDetailResponse(business_idx)

        getwithInfoResponse.enqueue(object : Callback<GetSupportDetailResponse> {
            override fun onFailure(call: Call<GetSupportDetailResponse>, t: Throwable) {
                Log.e("지원사업 상세 정보 fail", t.toString())
            }

            override fun onResponse(call: Call<GetSupportDetailResponse>, response: Response<GetSupportDetailResponse>) {
                val temp: ArrayList<SupportDetailData> = response.body()!!.data
                val status = response.body()!!.status

                if (temp.size > 0) {
                    if (status == 200) {
                        bsName.text = temp[0].bsName                // 사업 공고 타이틀
                        summery.text = temp[0].summery              // 사업 개요
                        target.text = temp[0].target                // 지원분야 및 대상
                        classifyList.text = temp[0].classifyList    // 분류체계
                        endDate.text = temp[0].endDate + " 까지"    // 신청기간
                        link = temp[0].link
                    }
                }
            }


        })
    }

    /* intent 로 리사이클러뷰 아이템 받아오기 */
    fun getIntentData(){
        business_idx = intent.getIntExtra("bs_idx", -1)
    }

    /* 상세보기 버튼 클릭 이벤트 */
    fun btnLookDetail(){
        btn_detail.setOnClickListener {
            Log.d("chohee", link)
            var intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("link", link)
            startActivity(intent)
        }
    }


}
