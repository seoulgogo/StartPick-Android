package com.seoulapp.startpick.base

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class BasePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val setOfFragments : MutableSet<Fragment> = mutableSetOf()

    override fun getItem(position: Int): Fragment {
        return setOfFragments.elementAt(position)
    }
    override fun getCount(): Int = setOfFragments.size

    fun addFragment(fragment: Fragment) {
        setOfFragments.add(fragment)
        notifyDataSetChanged()
    }
}