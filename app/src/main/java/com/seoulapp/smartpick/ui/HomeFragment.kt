package com.seoulapp.smartpick.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulapp.smartpick.R
import com.seoulapp.smartpick.adapter.TestAdapter
import com.seoulapp.smartpick.data.TestData
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var rootView: View
    lateinit var testViewAdapter : TestAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(R.layout.fragment_home, container, false)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setRecyclerView()
    }

    fun setRecyclerView() {
        var testDataList: ArrayList<TestData> = ArrayList()
        testDataList.add(TestData("테스트입니당11", "11"))
        testDataList.add(TestData("테스트입니당22", "22"))
        testDataList.add(TestData("테스트입니당33", "33"))
        testDataList.add(TestData("테스트입니당44", "44"))
        testDataList.add(TestData("테스트입니당55", "55"))
        testDataList.add(TestData("테스트입니당66", "66"))
        testDataList.add(TestData("테스트입니당77", "77"))
        testDataList.add(TestData("테스트입니당88", "88"))
        testDataList.add(TestData("테스트입니당99", "99"))
        testDataList.add(TestData("테스트입니당1010", "1010"))


        testViewAdapter = TestAdapter(activity!!, testDataList)
        rv_text_home_frag.adapter = testViewAdapter
        rv_text_home_frag.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

    }

}

