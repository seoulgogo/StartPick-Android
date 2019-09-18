package com.seoulapp.startpick.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulapp.startpick.R

import android.widget.LinearLayout
import android.widget.RelativeLayout

import com.seoulapp.startpick.base.BasePagerAdapter
import com.seoulapp.startpick.ui.adapter.MypagenaviAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_mypage.*



class MypageFragment : Fragment() {

    private lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_mypage, container, false)


        //configureMainTab()

        return rootView
    }

/*
    //ViewPager
    private fun configureMainTab() {

        vp_mypage_fragment.adapter = MypagenaviAdapter(fragmentManager!!, 3)
        vp_mypage_fragment.offscreenPageLimit = 2

        */
/*     tl_community_post_frag.run {
                 setupWithViewPager(vp_community_post_frag)

                 getTabAt(0)!!.setText("최신글")
                 getTabAt(1)!!.setText("인기글")
             }
             *//*


        tl_mypage_fragment.setupWithViewPager(vp_mypage_fragment)
        val topTabLayout: View = activity!!.layoutInflater.inflate(R.layout.tablayout_navi_mypage_fragment, null, false)
        tl_mypage_fragment.getTabAt(0)!!.customView =
                topTabLayout.findViewById(R.id.rl_scrap_mypage_frag) as RelativeLayout
        tl_mypage_fragment.getTabAt(1)!!.customView =
                topTabLayout.findViewById(R.id.rl_resume_mypage_navi_frag) as RelativeLayout
        tl_mypage_fragment.getTabAt(2)!!.customView =
                topTabLayout.findViewById(R.id.rl_supportstatus_mypage_navi_frag) as RelativeLayout

    }

*/


}
