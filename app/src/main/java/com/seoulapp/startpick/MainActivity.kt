package com.seoulapp.startpick

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.seoulapp.startpick.base.BasePagerAdapter
import com.seoulapp.startpick.ui.*
import com.seoulapp.startpick.ui.mypage.MypageFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ViewPager
        activity_main_vp_container.run {
            adapter = BasePagerAdapter(supportFragmentManager).apply {
                addFragment(HomeFragment())
                addFragment(JobFragment())
                addFragment(SupportBusinessFragment())
                addFragment(MapFragment())
                addFragment(MypageFragment())
            }
            offscreenPageLimit = 4
        }

        // TabLayout
        activity_main_tl_navi.run{
            val navigationLayout: View =
                    LayoutInflater.from(this@MainActivity).inflate(R.layout.activity_main_navi, null, false)
            setupWithViewPager(activity_main_vp_container)
            getTabAt(0)!!.customView =
                    navigationLayout.findViewById(R.id.ll_home_main_navi_act) as LinearLayout
            getTabAt(1)!!.customView =
                    navigationLayout.findViewById(R.id.ll_with_main_navi_act) as LinearLayout
            getTabAt(2)!!.customView =
                    navigationLayout.findViewById(R.id.ll_support_main_navi_act) as LinearLayout
            getTabAt(3)!!.customView =
                    navigationLayout.findViewById(R.id.ll_place_main_navi_act) as LinearLayout
            getTabAt(4)!!.customView =
                    navigationLayout.findViewById(R.id.ll_mypage_main_navi_act) as LinearLayout
        }
    }

}
