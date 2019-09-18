package com.seoulapp.startpick.ui.SupportInnerFragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulapp.startpick.R
import com.seoulapp.startpick.adapter.SupportAdapter
import com.seoulapp.startpick.data.SupportData
import kotlinx.android.synthetic.main.frag_total_support_inner.*

class EducationFragment : Fragment() {
    lateinit var supportAdapter : SupportAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_total_support_inner, container, false)!!
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setRecyclerView()
    }

    fun setRecyclerView(){
        var dataList: ArrayList<SupportData> = ArrayList()
        dataList.add(SupportData("2019년 사회적경제기업 스토어36.5 리뉴얼 지원사업 참여매장 모집 공고", "고용노동부", "~19.09.09"))
        dataList.add(SupportData("2019년 사회적경제기업 스토어36.5 리뉴얼 지원사업 참여매장 모집 공고", "고용노동부", "~19.09.09"))
        dataList.add(SupportData("공고 1", "고용노동부", "~19.09.09"))
        dataList.add(SupportData("공고 2", "고용노동부", "~19.09.09"))
        dataList.add(SupportData("공고 3", "고용노동부", "~19.09.09"))
        dataList.add(SupportData("공고 4", "고용노동부", "~19.09.09"))
        dataList.add(SupportData("공고 5", "고용노동부", "~19.09.09"))
        dataList.add(SupportData("공고 6", "고용노동부", "~19.09.09"))
        dataList.add(SupportData("공고 7", "고용노동부", "~19.09.09"))
        dataList.add(SupportData("공고 8", "고용노동부", "~19.09.09"))


        supportAdapter = SupportAdapter(activity!!, dataList)
        recycle_total.adapter = supportAdapter
        recycle_total.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

    }
}