package com.seoulapp.startpick.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulapp.startpick.R
import com.seoulapp.startpick.adapter.InfoHomeAdapter

import com.seoulapp.startpick.data.InfoHomefragData
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var rootView: View
    lateinit var testViewAdapter : InfoHomeAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(R.layout.fragment_home, container, false)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setRecyclerView()

        //setNewRecyclerView()
        //setPostRecyclerView()

    }

    fun setRecyclerView() {
        var testDataList: ArrayList<InfoHomefragData> = ArrayList()
        testDataList.add(InfoHomefragData("http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD","SNS 콘텐츠 크리에이터1", "서울시창업지원센터","콘텐츠"))
        testDataList.add(InfoHomefragData("http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD","SNS 콘텐츠 크리에이터2", "서울시창업지원센터","콘텐츠"))
        testDataList.add(InfoHomefragData("http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD","SNS 콘텐츠 크리에이터3", "서울시창업지원센터","콘텐츠"))
        testDataList.add(InfoHomefragData("http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD","SNS 콘텐츠 크리에이터4", "서울시창업지원센터","콘텐츠"))
        testDataList.add(InfoHomefragData("http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD","SNS 콘텐츠 크리에이터5", "서울시창업지원센터","콘텐츠"))
        testDataList.add(InfoHomefragData("http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD","SNS 콘텐츠 크리에이터6", "서울시창업지원센터","콘텐츠"))
        testDataList.add(InfoHomefragData("http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD","SNS 콘텐츠 크리에이터7", "서울시창업지원센터","콘텐츠"))


        testViewAdapter = InfoHomeAdapter(activity!!, testDataList)
        //맞춤형
        rv_information_home_frag.adapter = testViewAdapter
        rv_information_home_frag.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        //방금올라온
        rv_new_info_home_frag.adapter = testViewAdapter
        rv_new_info_home_frag.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        //인기
        rv_realtime_info_home_frag.adapter = testViewAdapter
        rv_realtime_info_home_frag.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

    }
}

