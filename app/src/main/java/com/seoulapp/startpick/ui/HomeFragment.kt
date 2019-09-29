package com.seoulapp.startpick.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulapp.startpick.R
import com.seoulapp.startpick.adapter.InfoHomeAdapter

import com.seoulapp.startpick.db.SharedPreferenceController
import com.seoulapp.startpick.network.ApplicationController
import com.seoulapp.startpick.network.NetworkService
import com.seoulapp.startpick.network.get.GetMainNewOrderResponse
import com.seoulapp.startpick.data.MainOrderData
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var rootView: View
    lateinit var homeViewAdapter : InfoHomeAdapter

    lateinit var url : Uri

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(R.layout.fragment_home, container, false)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        //통신
        getNewOrder()
        getCustomizeOrder()
        getlikeOrder()


        setOnClickListener()
    }

    fun setOnClickListener(){

        img_banner_home_fragment.setOnClickListener {

            url = Uri.parse("https://dcamp.kr/event/19942")
            var intent = Intent(Intent.ACTION_VIEW, url)
            startActivity(intent)
        }
    }

    //방금 올라온 공고
    private fun getNewOrder() {

        val getMainNewOdderResponse: Call<GetMainNewOrderResponse> = networkService.getMainNewOrder()

        getMainNewOdderResponse.enqueue(object : Callback<GetMainNewOrderResponse> {

            override fun onFailure(call: Call<GetMainNewOrderResponse>, t: Throwable) {
                Log.e("home 방금올라온 공고 fail", t.toString())
            }

            override fun onResponse(call: Call<GetMainNewOrderResponse>, response: Response<GetMainNewOrderResponse>
            ) {
                Log.e("home 방금올라온 공고 success", response.body()!!.data.toString())

                val temp: ArrayList<MainOrderData> = response.body()!!.data
                val status = response.body()!!.status

                if (temp.size > 0) {
                    if (status == 200) {

                        var dataList: ArrayList<MainOrderData> = temp

                        homeViewAdapter = InfoHomeAdapter(activity!!, dataList)

                        //방금올라온
                        rv_new_info_home_frag.adapter = homeViewAdapter
                        rv_new_info_home_frag.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

                    }
                }
                else{
                    homeViewAdapter.dataList.clear()
                }

                Log.v("TAGG : size1 ", temp.size.toString())

            }
        })
    }

    //맞춤형 공고
    private fun getCustomizeOrder() {

        val getMainCustomizeOrderResponse: Call<GetMainNewOrderResponse> = networkService.getMainCustomizeOrder(7)

        getMainCustomizeOrderResponse.enqueue(object : Callback<GetMainNewOrderResponse> {

            override fun onFailure(call: Call<GetMainNewOrderResponse>, t: Throwable) {
                Log.e("home 맞춤형 공고 fail", t.toString())
            }

            override fun onResponse(call: Call<GetMainNewOrderResponse>, response: Response<GetMainNewOrderResponse>
            ) {
                Log.e("home 맞춤형 공고 success", response.body()!!.data.toString())

                val temp: ArrayList<MainOrderData> = response.body()!!.data
                val status = response.body()!!.status

                if (temp.size > 0) {
                    if (status == 200) {

                        var dataList: ArrayList<MainOrderData> = temp

                        homeViewAdapter = InfoHomeAdapter(activity!!, dataList)

                        //맞춤형
                        rv_information_home_frag.adapter = homeViewAdapter
                        rv_information_home_frag.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
                    }
                }
                else{
                    homeViewAdapter.dataList.clear()
                }
                Log.v("TAGG : size1 ", temp.size.toString())
            }
        })
    }

    //인기
    private fun getlikeOrder() {

        val getMainlikeOrderResponse: Call<GetMainNewOrderResponse> = networkService.getMainlikeOrder()

        getMainlikeOrderResponse.enqueue(object : Callback<GetMainNewOrderResponse> {

            override fun onFailure(call: Call<GetMainNewOrderResponse>, t: Throwable) {
                Log.e("home 인기 공고 fail", t.toString())
            }

            override fun onResponse(call: Call<GetMainNewOrderResponse>, response: Response<GetMainNewOrderResponse>
            ) {
                Log.e("home 인기 공고 success", response.body()!!.data.toString())

                val temp: ArrayList<MainOrderData> = response.body()!!.data
                val status = response.body()!!.status

                if (temp.size > 0) {
                    if (status == 200) {

                        var dataList: ArrayList<MainOrderData> = temp

                        homeViewAdapter = InfoHomeAdapter(activity!!, dataList)

                        //인기
                        rv_realtime_info_home_frag.adapter = homeViewAdapter
                        rv_realtime_info_home_frag.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

                    }
                }
                else{
                    homeViewAdapter.dataList.clear()
                }

                Log.v("TAGG : size1 ", temp.size.toString())

            }
        })
    }



}

