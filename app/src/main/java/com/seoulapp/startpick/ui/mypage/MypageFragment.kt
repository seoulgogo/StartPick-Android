package com.seoulapp.startpick.ui.mypage

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulapp.startpick.R
import android.widget.RelativeLayout
import com.seoulapp.startpick.ui.adapter.MypagenaviAdapter
import kotlinx.android.synthetic.main.fragment_mypage.*


class MypageFragment : Fragment() {

    private lateinit var rootView: View

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        configureMainTab()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_mypage, container, false)

        return rootView
    }

    //ViewPager
    private fun configureMainTab() {

        vp_noswipe_mypage_fragment.adapter = MypagenaviAdapter(childFragmentManager!!, 3)
        vp_noswipe_mypage_fragment.offscreenPageLimit = 2


        tl_mypage_fragment.setupWithViewPager(vp_noswipe_mypage_fragment)

        val topTabLayout: View = activity!!.layoutInflater.inflate(R.layout.tablayout_navi_mypage_fragment, null, false)
        tl_mypage_fragment.getTabAt(0)!!.customView =
                topTabLayout.findViewById(R.id.rl_scrap_mypage_frag) as RelativeLayout
        tl_mypage_fragment.getTabAt(1)!!.customView =
                topTabLayout.findViewById(R.id.rl_resume_mypage_navi_frag) as RelativeLayout
        tl_mypage_fragment.getTabAt(2)!!.customView =
                topTabLayout.findViewById(R.id.rl_supportstatus_mypage_navi_frag) as RelativeLayout

    }
}
