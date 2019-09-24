package com.seoulapp.startpick.ui.mypage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulapp.startpick.R
import com.seoulapp.startpick.ui.adapter.ReceivedSupportAdapter
import com.seoulapp.startpick.data.ReceivedSupportData
import com.seoulapp.startpick.ui.adapter.ResumeAdapter
import kotlinx.android.synthetic.main.fragment_mypage_resume.*
import kotlinx.android.synthetic.main.fragment_mypage_support_state.*
import org.jetbrains.anko.support.v4.startActivity

class MypageResumeFragment : Fragment() {

    private lateinit var rootView: View

    lateinit var mypageSupportBusinessAdapter : ResumeAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(R.layout.fragment_mypage_resume, container, false)


        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setOnClickListener()
        setRecyclerView()
    }

    fun setOnClickListener() {
        btn_write_resume_mypage_fg.setOnClickListener {
            startActivity<MyapageResumeActivity>()
        }
    }

    //리사이클러뷰
    fun setRecyclerView() {

        var dataList: ArrayList<ReceivedSupportData> = ArrayList()
        dataList.add(ReceivedSupportData("지원사업 참여매장", "최근수정일 : 2019.09.15"))
        dataList.add(ReceivedSupportData("지원사업 참여매장", "최근수정일 : 2019.09.15"))
        dataList.add(ReceivedSupportData("지원사업 참여매장", "최근수정일 : 2019.09.15"))
        dataList.add(ReceivedSupportData("지원사업 참여매장", "최근수정일 : 2019.09.15"))
        dataList.add(ReceivedSupportData("지원사업 참여매장", "최근수정일 : 2019.09.15"))
        dataList.add(ReceivedSupportData("지원합니다!", "최근수정일 : 2019.09.15"))
        dataList.add(ReceivedSupportData("지원사업 참여매장", "최근수정일 : 2019.09.15"))
        dataList.add(ReceivedSupportData("지원사업 참여매장", "최근수정일 : 2019.09.15"))
        dataList.add(ReceivedSupportData("지원사업 참여매장", "최근수정일 : 2019.09.15"))
        dataList.add(ReceivedSupportData("지원사업 참여매장", "최근수정일 : 2019.09.15"))
        dataList.add(ReceivedSupportData("안녕하세요", "최근수정일 : 2019.09.15"))
        dataList.add(ReceivedSupportData("지원사업 참여매장", "최근수정일 : 2019.09.15"))
        dataList.add(ReceivedSupportData("지원사업 참여매장", "최근수정일 : 2019.09.15"))


        mypageSupportBusinessAdapter = ResumeAdapter(activity!!, dataList)
        rv_mypage_resume_fg.adapter = mypageSupportBusinessAdapter
        rv_mypage_resume_fg.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
    }
}
