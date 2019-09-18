package com.seoulapp.startpick.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.seoulapp.startpick.ui.HomeFragment
import com.seoulapp.startpick.ui.MypagescrapFragment

class MypagenaviAdapter(fm: FragmentManager, private val num_fragment: Int) : FragmentStatePagerAdapter(fm) {


    //##HomeFragment는 변경해줘야함 MypagescrapFragment로!!!
    companion object {
        private var mypagescrapFragment: HomeFragment? = null
        //private var communityPopularFragment: CommunityPopularFragment? = null

        @Synchronized
        fun getMypageScrapFragment(): HomeFragment {
            if (mypagescrapFragment == null) mypagescrapFragment =
                    HomeFragment()
            return mypagescrapFragment!!
        }
    }

    override fun getItem(p0: Int): Fragment? {
        return when (p0) {
            0 -> getMypageScrapFragment()
            1 -> getMypageScrapFragment()
            2 -> getMypageScrapFragment()
            else -> return null
        }
    }

    override fun getCount(): Int {
        return num_fragment
    }
}
