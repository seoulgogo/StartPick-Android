package com.seoulapp.smartpick.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class TabPagerAdapter(fm: FragmentManager?, tab : Int) : FragmentStatePagerAdapter(fm) {
    private var tabcount = tab

    override fun getItem(p0: Int): Fragment {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        return tabcount
    }
}