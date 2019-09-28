package com.seoulapp.startpick.ui

import android.app.Dialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.seoulapp.startpick.R
import com.seoulapp.startpick.data.WithusDetailData
import com.seoulapp.startpick.network.ApplicationController
import com.seoulapp.startpick.network.NetworkService
import com.seoulapp.startpick.network.get.GetWithusDetailResponse
import kotlinx.android.synthetic.main.activity_with_detail.*
import org.jetbrains.anko.ctx
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WithDetailActivity : AppCompatActivity() {

    var withUs_idx : Int = 0        // 공고 idx 변수

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_detail)

        btn_back.setOnClickListener { finish() }                    // 뒤로가기 버튼 세팅
        three_point.setOnClickListener { showPopup(three_point) }   // 메뉴 버튼 클릭 이벤트
        getIntentData()                                             // intent로 넘어온 데이터 받기
        getWithusDetailResponse()                                   // 함께해요 아이템 디테일 데이터 통신

    }

    /** NetworkService 파일에 정의한 함수 */
    /** 함께해요 디테일 정보 통신 */
    private fun getWithusDetailResponse() {

        val getwithInfoResponse: Call<GetWithusDetailResponse> = networkService.getWithusDetailResponse(withUs_idx)

        getwithInfoResponse.enqueue(object : Callback<GetWithusDetailResponse> {
            override fun onFailure(call: Call<GetWithusDetailResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "공고 정보를 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<GetWithusDetailResponse>, response: Response<GetWithusDetailResponse>) {
                val temp: ArrayList<WithusDetailData> = response.body()!!.data
                val status = response.body()!!.status

                if (temp.size > 0) {
                    if (status == 200) {
                        // 디테일 뷰에 정보 세팅
                        Glide.with(ctx).load(temp[0].thumnail).into(ivWithusDetailThumb)    // 썸네일 이미지 세팅
                        tvWithusDetailTitle.text = temp[0].detailJob + " (" + temp[0].recrutNum + "명)"          // 공고 타이틀 세팅
                        tvWithusDetailStartupname.text = temp[0].companyName                                    // 스타트업 이름 세팅
                        when(temp[0].startUp_idx){                                                              // 스타트업 분야 세팅
                            1 -> {
                                tvWithusDetailStartupIdx.text = "IT"
                                tvWithusDetailJob.text = "IT"
                            }
                            2 -> {
                                tvWithusDetailStartupIdx.text = "여행"
                                tvWithusDetailJob.text = "여행"
                            }
                            3 -> {
                                tvWithusDetailStartupIdx.text = "교육"
                                tvWithusDetailJob.text = "교육"
                            }
                            4 -> {
                                tvWithusDetailStartupIdx.text = "금융"
                                tvWithusDetailJob.text = "금융"
                            }
                            5 -> {
                                tvWithusDetailStartupIdx.text = "보안"
                                tvWithusDetailJob.text = "보안"
                            }
                            6 -> {
                                tvWithusDetailStartupIdx.text = "교통"
                                tvWithusDetailJob.text = "교통"
                            }
                            7 -> {
                                tvWithusDetailStartupIdx.text = "건설"
                                tvWithusDetailJob.text = "건설"
                            }
                            8 -> {
                                tvWithusDetailStartupIdx.text = "게임"
                                tvWithusDetailJob.text = "게임"
                            }
                            9 -> {
                                tvWithusDetailStartupIdx.text = "부동산"
                                tvWithusDetailJob.text = "부동산"
                            }
                            10 -> {
                                tvWithusDetailStartupIdx.text = "친환경"
                                tvWithusDetailJob.text = "친환경"
                            }
                            11 -> {
                                tvWithusDetailStartupIdx.text = "헬스케어"
                                tvWithusDetailJob.text = "헬스케어"
                            }
                            12 -> {
                                tvWithusDetailStartupIdx.text = "사회봉사"
                                tvWithusDetailJob.text = "사회봉사"
                            }
                            13 -> {
                                tvWithusDetailStartupIdx.text = "자연과학"
                                tvWithusDetailJob.text = "자연과학"
                            }
                            14 -> {
                                tvWithusDetailStartupIdx.text = "전자제품"
                                tvWithusDetailJob.text = "전자제품"
                            }
                            15 -> {
                                tvWithusDetailStartupIdx.text = "물류/유통"
                                tvWithusDetailJob.text = "물류/유통"
                            }
                            16 -> {
                                tvWithusDetailStartupIdx.text = "광고/마케팅"
                                tvWithusDetailJob.text = "광고/마케팅"
                            }
                            17 -> {
                                tvWithusDetailStartupIdx.text = "농/축/수산업"
                                tvWithusDetailJob.text = "농/축/수산업"
                            }
                            18 -> {
                                tvWithusDetailStartupIdx.text = "엔터테인먼트"
                                tvWithusDetailJob.text = "엔터테인먼트"
                            }
                            19 -> {
                                tvWithusDetailStartupIdx.text = "바이오/의료"
                                tvWithusDetailJob.text = "바이오/의료"
                            }
                            20 -> {
                                tvWithusDetailStartupIdx.text = "기타"
                                tvWithusDetailJob.text = "기타"
                            }
                        }
                        if(temp[0].salary == "0"){                                                                // 월급 세팅
                            tvWithusDetailSalary.text = "협상가능"
                        }else{
                            tvWithusDetailSalary.text = temp[0].salary + "원"
                        }
                        when(temp[0].city_idx){                                                                 // 근무지역 세팅
                            1 -> tvWithusDetailCity.text = "강남구"
                            2 -> tvWithusDetailCity.text = "강동구"
                            3 -> tvWithusDetailCity.text = "강북구"
                            4 -> tvWithusDetailCity.text = "강서구"
                            5 -> tvWithusDetailCity.text = "관악구"
                            6 -> tvWithusDetailCity.text = "광진구"
                            7 -> tvWithusDetailCity.text = "구로구"
                            8 -> tvWithusDetailCity.text = "금천구"
                            9 -> tvWithusDetailCity.text = "노원구"
                            10 -> tvWithusDetailCity.text = "도봉구"
                            11 -> tvWithusDetailCity.text = "동대문구"
                            12 -> tvWithusDetailCity.text = "동작구"
                            13 -> tvWithusDetailCity.text = "마포구"
                            14 -> tvWithusDetailCity.text = "서대문구"
                            15 -> tvWithusDetailCity.text = "서초구"
                            16 -> tvWithusDetailCity.text = "성동구"
                            17 -> tvWithusDetailCity.text = "성북구"
                            18 -> tvWithusDetailCity.text = "송파구"
                            19 -> tvWithusDetailCity.text = "양천구"
                            20 -> tvWithusDetailCity.text = "영등포구"
                            21 -> tvWithusDetailCity.text = "용산구"
                            22 -> tvWithusDetailCity.text = "은평구"
                            23 -> tvWithusDetailCity.text = "종로구"
                            24 -> tvWithusDetailCity.text = "중구"
                            25 -> tvWithusDetailCity.text = "중랑구"
                        }
                        tvWithusDetailMaintask.text = temp[0].mainTask          // 주요 업무 세팅
                        tvWithusDetailIntro.text = temp[0].intro                // 사업 소개 세팅
                        tvWithusDetailCompanyname.text = temp[0].companyName    // 회사명 세팅
                        tvWithusDetailManagernm.text = temp[0].managerName      // 담당자 이름 세팅
                        tvWithusDetailPhone.text = temp[0].managerPhone         // 연락처 세팅
                        tvWithusDetailEmail.text = temp[0].managerEmail         // 이메일 세팅
                    }
                }
            }
        })
    }

    /** 인텐트 정보 받기 */
    fun getIntentData(){
        withUs_idx = intent.getIntExtra("withUs_idx", -1)
    }

    /** 메뉴 창 띄우기 */
    private fun showPopup(view: View) {
        var popup = PopupMenu(this, view)
        popup.inflate(R.menu.menu_main)

        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

            when (item!!.itemId) {
                // 수정버튼 클릭시
                R.id.menu_modified -> {

                }
                // 삭제버튼 클릭시
                R.id.menu_delete -> {
                    /* 다이얼로그 띄우기 */
                    val dialog = Dialog(this)
                    dialog.setContentView(R.layout.customdialog_menu_modify)
                    val no = dialog.findViewById<TextView>(R.id.no)
                    val yes = dialog.findViewById<TextView>(R.id.yes)
                    no.setOnClickListener {
                        dialog.dismiss() // 다이얼로그 끄기
                    }
                    yes.setOnClickListener {
                        Toast.makeText(this, "삭제되었습니다.", Toast.LENGTH_SHORT).show()
                    }

                    dialog.show()
                }
            }
            true
        })

        popup.show()
    }
}
