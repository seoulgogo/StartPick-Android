package com.seoulapp.startpick.ui


import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
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
import kotlinx.android.synthetic.main.activity_with_filter.*
import kotlinx.android.synthetic.main.fragment_job.*
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.textColor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WithFragment : Fragment() {

    private lateinit var rootView: View
    lateinit var withRecycleAdapter : WithRecyAdapter   // 리사이클러뷰 어댑터 변수
    var startup_idx : Int = 0                           // 필터에서 적용된 스타트업 분야 변수
    var job_idx : Int = 0                               // 필터에서 적용된 직무 분야 변수
    var item_count : Int = 0                            // 리사이클러뷰 아이템 개수 변수

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        // 필터 뷰에서 필터 값 받기
        if(resultCode == RESULT_OK){
            if(requestCode == 3000){
                startup_idx = data?.getIntExtra("startup_idx", -1)!!
                job_idx = data.getIntExtra("job_idx", -1)

                // 스타트업 분야랑 직무 둘다 전체 선택했을 경우
                if(startup_idx == 0 && job_idx == 0){
                    Log.d("chohee", startup_idx.toString())
                    Log.d("chohee", job_idx.toString())
                    setRecyclerView()

                    // 필터 버튼 색깔 활성화 해제
                    ivFilterBtn.setImageResource(R.drawable.icon_filter)
                    btn_filter.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_gray)
                    tvFilterBtn.textColor = Color.parseColor("#212529")
                }else{
                    setFilterAdaptRecyclerView()
                }
            }
        }
    }

    /** NetworkService 파일에 정의한 함수 */
    /** 함께해요 전체 리스트 통신 */
    private fun getWithusAllResponse() {

        val getwithInfoResponse: Call<GetWithusAllResponse> = networkService.getWithusAllResponse()

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
                        // 리사이클러뷰 아이템 개수 세팅
                        item_count = temp.size
                        tvWithCount.text = "전체 " + item_count.toString() + "개"

                        val position = withRecycleAdapter.itemCount
                        withRecycleAdapter.dataList.addAll(temp)
                        withRecycleAdapter.notifyDataSetChanged()

                    }
                }else{
                    Toast.makeText(context, "모집하는 공고가 없습니다.", Toast.LENGTH_SHORT).show()
                    tvWithCount.text = "전체 0개"
                }
            }


        })
    }

    /** NetworkService 파일에 정의한 함수 */
    /** 필터 적용 후 리사이클러뷰 데이터 통신 */
    private fun getWithusFilterResponse() {

        val getwithInfoResponse: Call<GetWithusFilterResponse> = networkService.getWithusFilterResponse(startup_idx, job_idx)

        getwithInfoResponse.enqueue(object : Callback<GetWithusFilterResponse> {
            override fun onFailure(call: Call<GetWithusFilterResponse>, t: Throwable) {
                Toast.makeText(context, "리스트를 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<GetWithusFilterResponse>, response: Response<GetWithusFilterResponse>) {
                val temp: ArrayList<WithusItemData> = response.body()!!.data
                val status = response.body()!!.status

                if (temp.size > 0) {
                    if (status == 200) {
                        // 리사이클러뷰 아이템 개수 세팅
                        item_count = temp.size
                        tvWithCount.text = "전체 " + item_count.toString() + "개"

                        val position = withRecycleAdapter.itemCount
                        withRecycleAdapter.dataList.addAll(temp)
                        withRecycleAdapter.notifyDataSetChanged()

                    }
                }else{
                    Toast.makeText(context, "모집하는 공고가 없습니다.", Toast.LENGTH_SHORT).show()
                    tvWithCount.text = "전체 0개"
                }
            }
        })
    }


    /** 전체 필터일 때 리사이클러 뷰 설정 */
    fun setRecyclerView() {

        var withItemDataArray: ArrayList<WithusItemData> = ArrayList()

        withRecycleAdapter = WithRecyAdapter(activity!!, withItemDataArray)
        fragment_job_recyclerview.adapter = withRecycleAdapter
        fragment_job_recyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        getWithusAllResponse()
    }

    /** 필터 적용된 리사이클러 뷰 설정 */
    fun setFilterAdaptRecyclerView() {

        var withItemDataArray: ArrayList<WithusItemData> = ArrayList()

        withRecycleAdapter = WithRecyAdapter(activity!!, withItemDataArray)
        fragment_job_recyclerview.adapter = withRecycleAdapter
        fragment_job_recyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        getWithusFilterResponse()
    }

    /** 플로팅 이미지 설정 */
    fun floatingBtn() {
        // 글쓰기 버튼 클릭 리스너
        iv_write.setOnClickListener {
            var intent = Intent(this.context, WriteActivity::class.java)
            startActivity(intent)
        }
    }

    /** 필터 버튼 클릭 이벤트 */
    fun filterClick(){
        btn_filter.setOnClickListener {
            // 필터 액티비티로 전환
            var intent = Intent(this.context, WithFilterActivity::class.java)
            startActivityForResult(intent, 3000)

            // 필터 버튼 색깔 활성화
            ivFilterBtn.setImageResource(R.drawable.icon_filter_active)
            btn_filter.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
            tvFilterBtn.textColor = Color.parseColor("#22b573")
        }
    }


}


