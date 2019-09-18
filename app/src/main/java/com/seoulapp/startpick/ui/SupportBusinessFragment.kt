package com.seoulapp.startpick.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.seoulapp.startpick.R
import com.seoulapp.startpick.adapter.TabViewPagerAdapter

import com.seoulapp.startpick.ui.SupportInnerFragment.*
import kotlinx.android.synthetic.main.fragment_support_business.*


class SupportBusinessFragment : Fragment() {

    private lateinit var rootView: View


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_support_business, container, false)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        /* 탭 세팅 */
        val tabViewPagerAdapter = TabViewPagerAdapter(supportFragmentManager = fragmentManager)
        tabViewPagerAdapter.addFragment(TotalFragment(), "전체")
        tabViewPagerAdapter.addFragment(PolicyFragment(), "정책")
        tabViewPagerAdapter.addFragment(EducationFragment(), "교육")
        tabViewPagerAdapter.addFragment(ConsultingFragment(), "컨설팅")
        tabViewPagerAdapter.addFragment(FacilityFragment(), "시설")
        tabViewPagerAdapter.addFragment(CommercialFragment(), "사업화")
        tabViewPagerAdapter.addFragment(EventFragment(), "행사")
        tabViewPagerAdapter.addFragment(EtcFragment(), "기타")

        vpg_frag_support.adapter = tabViewPagerAdapter
        tablayout_frag_support.setupWithViewPager(vpg_frag_support)
    }

}
