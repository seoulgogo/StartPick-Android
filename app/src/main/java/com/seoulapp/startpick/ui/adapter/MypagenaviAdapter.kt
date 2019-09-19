package com.seoulapp.startpick.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.seoulapp.startpick.ui.mypage.MypageSupportStateFragment
import com.seoulapp.startpick.ui.mypage.MypageResumeFragment
import com.seoulapp.startpick.ui.mypage.MypageScrapFragment

class MypagenaviAdapter(fm: FragmentManager, private val num_fragment: Int) : FragmentStatePagerAdapter(fm) {


    //##HomeFragment는 변경해줘야함 MypagescrapFragment로!!!
    companion object {
        private var mypagescrapFragment: MypageScrapFragment? = null
        private var mypageresumeFragment: MypageResumeFragment? = null
        private var mypageSupportStateFragment: MypageSupportStateFragment? = null

        @Synchronized
        fun getMypageScrapFragment(): MypageScrapFragment {
            if (mypagescrapFragment == null) mypagescrapFragment =
                    MypageScrapFragment()
            return mypagescrapFragment!!
        }

        @Synchronized
        fun getMypageResumeFragment(): MypageResumeFragment {
            if (mypageresumeFragment == null) mypageresumeFragment =
                    MypageResumeFragment()
            return mypageresumeFragment!!
        }

        @Synchronized
        fun getMypageStateFragment(): MypageSupportStateFragment {
            if (mypageSupportStateFragment == null) mypageSupportStateFragment =
                    MypageSupportStateFragment()
            return mypageSupportStateFragment!!
        }
    }

    override fun getItem(p0: Int): Fragment? {
        return when (p0) {
            0 -> getMypageScrapFragment()
            1 -> getMypageResumeFragment()
            2 -> getMypageStateFragment()
            else -> null
        }
    }

    override fun getCount(): Int {
        return num_fragment
    }
}
