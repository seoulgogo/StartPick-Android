package com.seoulapp.startpick.ui

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast

import com.seoulapp.startpick.R
import com.seoulapp.startpick.adapter.SupportAdapter
import com.seoulapp.startpick.data.SupportItemData
import com.seoulapp.startpick.data.WithusItemData
import com.seoulapp.startpick.network.ApplicationController
import com.seoulapp.startpick.network.NetworkService
import com.seoulapp.startpick.network.get.GetSupportListAll
import com.seoulapp.startpick.network.get.GetSupportTabResponse
import com.seoulapp.startpick.network.get.GetWithusAllResponse
import kotlinx.android.synthetic.main.fragment_job.*
import kotlinx.android.synthetic.main.fragment_support_business.*
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.textColor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SupportBusinessFragment : Fragment() {

    private lateinit var rootView: View
    lateinit var supportRecyAdapter : SupportAdapter // 지원사업 리사이클러뷰 어댑터
    var totalCount : Int = 0 // 아이템 갯수 변수
    var tabIdx : Int = 0 // 탭 idx 변수

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_support_business, container, false)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tabClickEvent() // 탭바 클릭 이벤트
        setTotalRecyclerView() // 전체 리사이클러뷰 세팅
        btnOrderClick() // 순서버튼 클릭 이벤트

    }

    fun tabClickEvent(){
        tab1.setOnClickListener {
            clear()
            tv1.setTextColor(resources.getColor(R.color.maincolor))
            v1.setBackgroundResource(R.color.maincolor)
            getSupportTotalResponse()
        }
        tab2.setOnClickListener {
            clear()
            tv2.setTextColor(resources.getColor(R.color.maincolor))
            v2.setBackgroundResource(R.color.maincolor)
            tabIdx = 1
            setTabRecyclerView()
        }
        tab3.setOnClickListener {
            clear()
            tv3.setTextColor(resources.getColor(R.color.maincolor))
            v3.setBackgroundResource(R.color.maincolor)
            tabIdx = 2
            setTabRecyclerView()
        }
        tab4.setOnClickListener {
            clear()
            tv4.setTextColor(resources.getColor(R.color.maincolor))
            v4.setBackgroundResource(R.color.maincolor)
            tabIdx = 3
            setTabRecyclerView()
        }
        tab5.setOnClickListener {
            clear()
            tv5.setTextColor(resources.getColor(R.color.maincolor))
            v5.setBackgroundResource(R.color.maincolor)
            tabIdx = 4
            setTabRecyclerView()
        }
        tab6.setOnClickListener {
            clear()
            tv6.setTextColor(resources.getColor(R.color.maincolor))
            v6.setBackgroundResource(R.color.maincolor)
            tabIdx = 5
            setTabRecyclerView()
        }
        tab7.setOnClickListener {
            clear()
            tv7.setTextColor(resources.getColor(R.color.maincolor))
            v7.setBackgroundResource(R.color.maincolor)
            tabIdx = 6
            setTabRecyclerView()
        }
        tab8.setOnClickListener {
            clear()
            tv8.setTextColor(resources.getColor(R.color.maincolor))
            v8.setBackgroundResource(R.color.maincolor)
        }


    }

    fun clear(){

        tv1.setTextColor(Color.parseColor("#212529"))
        tv2.setTextColor(Color.parseColor("#212529"))
        tv3.setTextColor(Color.parseColor("#212529"))
        tv4.setTextColor(Color.parseColor("#212529"))
        tv5.setTextColor(Color.parseColor("#212529"))
        tv6.setTextColor(Color.parseColor("#212529"))
        tv7.setTextColor(Color.parseColor("#212529"))
        tv8.setTextColor(Color.parseColor("#212529"))

        v1.setBackgroundResource(R.color.bar)
        v2.setBackgroundResource(R.color.bar)
        v3.setBackgroundResource(R.color.bar)
        v4.setBackgroundResource(R.color.bar)
        v5.setBackgroundResource(R.color.bar)
        v6.setBackgroundResource(R.color.bar)
        v7.setBackgroundResource(R.color.bar)
        v8.setBackgroundResource(R.color.bar)
    }

    /** NetworkService 파일에 정의한 함수 */
    private fun getSupportTotalResponse() {

        val getwithInfoResponse: Call<GetSupportListAll> = networkService.getSupportList()

        getwithInfoResponse.enqueue(object : Callback<GetSupportListAll> {
            override fun onFailure(call: Call<GetSupportListAll>, t: Throwable) {
                Log.e("지원사업 리스트 all list fail", t.toString())
                Toast.makeText(context, "리스트를 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<GetSupportListAll>, response: Response<GetSupportListAll>) {
                val temp: ArrayList<SupportItemData> = response.body()!!.data
                val status = response.body()!!.status
                totalCount = temp.size
                Log.d("chohee", totalCount.toString())
                if (temp.size > 0) {
                    if (status == 200) {
                        val position = supportRecyAdapter.itemCount
                        supportRecyAdapter.dataList.addAll(temp)
                        supportRecyAdapter.notifyDataSetChanged()

                        itemCount.text = "총 " + totalCount.toString() + "건"
                    }
                }
            }
        })
    }

    /** NetworkService 파일에 정의한 함수
     * 탭 카테고리에 따른 지원사업 리스트 Response */
    private fun getSupportTabResponse() {

        val getwithInfoResponse: Call<GetSupportTabResponse> = networkService.getSupportTabResponse(tabIdx)

        getwithInfoResponse.enqueue(object : Callback<GetSupportTabResponse> {
            override fun onFailure(call: Call<GetSupportTabResponse>, t: Throwable) {
                Toast.makeText(context, "리스트를 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<GetSupportTabResponse>, response: Response<GetSupportTabResponse>) {
                val temp: ArrayList<SupportItemData> = response.body()!!.data
                val status = response.body()!!.status
                val count = temp.size
                Log.d("chohee", totalCount.toString())
                if (temp.size > 0) {
                    if (status == 200) {
                        val position = supportRecyAdapter.itemCount
                        supportRecyAdapter.dataList.addAll(temp)
                        supportRecyAdapter.notifyDataSetChanged()

                        itemCount.text = "총 " + count.toString() + "건"
                    }
                }
            }
        })
    }

    fun setTotalRecyclerView(){
        var dataList: ArrayList<SupportItemData> = ArrayList()

        supportRecyAdapter = SupportAdapter(activity!!, dataList)
        recycle_support.adapter = supportRecyAdapter
        recycle_support.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        getSupportTotalResponse()

    }

    fun setTabRecyclerView(){
        var dataList: ArrayList<SupportItemData> = ArrayList()

        supportRecyAdapter = SupportAdapter(activity!!, dataList)
        recycle_support.adapter = supportRecyAdapter
        recycle_support.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        getSupportTabResponse()

    }

    /** 등록일 순 리사이블러 뷰 세팅*/
    fun setEnrollorderRecyclerView(){
        var dataList: ArrayList<SupportItemData> = ArrayList()

        supportRecyAdapter = SupportAdapter(activity!!, dataList)
        recycle_support.adapter = supportRecyAdapter
        recycle_support.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        getSupportEnrollorderResponse()

    }

    /** 마감일 순 리사이블러 뷰 세팅*/
    fun setEndorderRecyclerView(){
        var dataList: ArrayList<SupportItemData> = ArrayList()

        supportRecyAdapter = SupportAdapter(activity!!, dataList)
        recycle_support.adapter = supportRecyAdapter
        recycle_support.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        getSupportEndorderResponse()

    }

    /** 최신 순 리사이블러 뷰 세팅*/
    fun setStartorderRecyclerView(){
        var dataList: ArrayList<SupportItemData> = ArrayList()

        supportRecyAdapter = SupportAdapter(activity!!, dataList)
        recycle_support.adapter = supportRecyAdapter
        recycle_support.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        getSupportStartorderResponse()

    }

    /** NetworkService 파일에 정의한 함수 */
    /** 등록일순 정렬 GET 통신 */
    private fun getSupportEnrollorderResponse() {

        val getwithInfoResponse: Call<GetSupportListAll> = networkService.getSupportEnrollorderResponse()

        getwithInfoResponse.enqueue(object : Callback<GetSupportListAll> {
            override fun onFailure(call: Call<GetSupportListAll>, t: Throwable) {
                Toast.makeText(context, "리스트를 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<GetSupportListAll>, response: Response<GetSupportListAll>) {
                val temp: ArrayList<SupportItemData> = response.body()!!.data
                val status = response.body()!!.status

                if (temp.size > 0) {
                    if (status == 200) {
                        // 리사이클러뷰 아이템 개수 세팅
                        totalCount = temp.size
                        itemCount.text = "전체 " + totalCount.toString() + "개"

                        val position = supportRecyAdapter.itemCount
                        supportRecyAdapter.dataList.addAll(temp)
                        supportRecyAdapter.notifyDataSetChanged()

                    }
                }else{
                    Toast.makeText(context, "모집하는 공고가 없습니다.", Toast.LENGTH_SHORT).show()
                    tvWithCount.text = "전체 0개"
                }
            }
        })
    }

    /** NetworkService 파일에 정의한 함수 */
    /** 마감일순 정렬 GET 통신 */
    private fun getSupportEndorderResponse() {

        val getwithInfoResponse: Call<GetSupportListAll> = networkService.getSupportEndorderResponse()

        getwithInfoResponse.enqueue(object : Callback<GetSupportListAll> {
            override fun onFailure(call: Call<GetSupportListAll>, t: Throwable) {
                Toast.makeText(context, "리스트를 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<GetSupportListAll>, response: Response<GetSupportListAll>) {
                val temp: ArrayList<SupportItemData> = response.body()!!.data
                val status = response.body()!!.status

                if (temp.size > 0) {
                    if (status == 200) {
                        // 리사이클러뷰 아이템 개수 세팅
                        totalCount = temp.size
                        itemCount.text = "전체 " + totalCount.toString() + "개"

                        val position = supportRecyAdapter.itemCount
                        supportRecyAdapter.dataList.addAll(temp)
                        supportRecyAdapter.notifyDataSetChanged()

                    }
                }else{
                    Toast.makeText(context, "모집하는 공고가 없습니다.", Toast.LENGTH_SHORT).show()
                    tvWithCount.text = "전체 0개"
                }
            }
        })
    }

    /** NetworkService 파일에 정의한 함수 */
    /** 최신순 정렬 GET 통신 */
    private fun getSupportStartorderResponse() {

        val getwithInfoResponse: Call<GetSupportListAll> = networkService.getSupportStartorderResponse()

        getwithInfoResponse.enqueue(object : Callback<GetSupportListAll> {
            override fun onFailure(call: Call<GetSupportListAll>, t: Throwable) {
                Toast.makeText(context, "리스트를 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<GetSupportListAll>, response: Response<GetSupportListAll>) {
                val temp: ArrayList<SupportItemData> = response.body()!!.data
                val status = response.body()!!.status

                if (temp.size > 0) {
                    if (status == 200) {
                        // 리사이클러뷰 아이템 개수 세팅
                        totalCount = temp.size
                        itemCount.text = "전체 " + totalCount.toString() + "개"

                        val position = supportRecyAdapter.itemCount
                        supportRecyAdapter.dataList.addAll(temp)
                        supportRecyAdapter.notifyDataSetChanged()

                    }
                }else{
                    Toast.makeText(context, "모집하는 공고가 없습니다.", Toast.LENGTH_SHORT).show()
                    tvWithCount.text = "전체 0개"
                }
            }
        })
    }

    /** 순서 버튼 클릭 이벤트 */
    fun btnOrderClick(){
        btnOrder.setOnClickListener {
            showPopup(btnOrder)
        }
    }

    /** 메뉴 창 띄우기 */
    fun showPopup(view: View) {
        var popup = PopupMenu(context, view)
        popup.inflate(R.menu.menu_support_order)

        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

            when (item!!.itemId) {
                // 최신순 클릭시
                R.id.newOrder -> {
                    tvOrder.text = "최신순"
                    ivArray.setImageResource(R.drawable.icon_array_active)
                    btnOrder.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
                    tvOrder.textColor = Color.parseColor("#22b573")
                    setStartorderRecyclerView() // 리사이클러뷰 갱신
                }
                // 마감일순 클릭시
                R.id.endOrder -> {
                    tvOrder.text = "마감일순"
                    ivArray.setImageResource(R.drawable.icon_array_active)
                    btnOrder.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
                    tvOrder.textColor = Color.parseColor("#22b573")
                    setEndorderRecyclerView() // 리사이클러뷰 갱신
                }
                // 등록일 순 클릭시
                R.id.enrollOrder -> {
                    tvOrder.text = "등록일순"
                    ivArray.setImageResource(R.drawable.icon_array_active)
                    btnOrder.background = ContextCompat.getDrawable(ctx, R.drawable.round_border_green)
                    tvOrder.textColor = Color.parseColor("#22b573")
                    setEnrollorderRecyclerView()    // 리사이클러뷰 갱신
                }
            }
            true
        })
        popup.show()
    }
}
