package com.seoulapp.startpick.ui

import android.app.Dialog
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import com.seoulapp.startpick.R
import com.seoulapp.startpick.network.ApplicationController
import com.seoulapp.startpick.network.NetworkService
import kotlinx.android.synthetic.main.activity_with_detail.*


class WithDetailActivity : AppCompatActivity() {

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_detail)

        /** 이 액티비티의 기능들 */
        btn_back.setOnClickListener { finish() }
        three_point.setOnClickListener { showPopup(three_point) }   // 메뉴 버튼 클릭 이벤트
       // getWithusDetailResponse() // 함께해요 상세 뷰 통신
        /*************************/


    }

    /* 상태바 투명하게 만들기 */
    fun statusbarTransparency(){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = 0x00000000  // transparent
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val flags = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            window.addFlags(flags)
        }
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }

    /* NetworkService 파일에 정의한 함수 */
//    private fun getWithusFilterResponse() {
//
//        val getwithInfoResponse: Call<GetWithusFilterResponse> = networkService.getWithusDetailResponse()
//
//        getwithInfoResponse.enqueue(object : Callback<GetWithusFilterResponse> {
//            override fun onFailure(call: Call<GetWithusFilterResponse>, t: Throwable) {
//                Log.e("함께해요 상세뷰 all list fail", t.toString())
//            }
//
//            override fun onResponse(call: Call<GetWithusFilterResponse>, response: Response<GetWithusFilterResponse>) {
//                val temp: ArrayList<WithusFilterItemData> = response.body()!!.data
//                val status = response.body()!!.status
//
//                if (temp.size > 0) {
//                    if (status == 200) {
//
//
//
//                    }
//                }
//            }
//
//
//        })
//    }

    /** 팝업창 */
    private fun showPopup(view: View) {
        var popup = PopupMenu(this, view)
        popup.inflate(R.menu.menu_main)

        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

            when (item!!.itemId) {
                // 수정버튼 클릭시
                R.id.menu_modified -> {

                }
                // 삭제버튼 클릭시
                R.id.menu_delete -> {
                    /* 다이얼로그 띄우기 */
                    val dialog = Dialog(this)
                    dialog.setContentView(R.layout.custom_dialog)
                    val no = dialog.findViewById<TextView>(R.id.no)
                    val yes = dialog.findViewById<TextView>(R.id.yes)
                    no.setOnClickListener {
                        dialog.dismiss() // 다이얼로그 끄기
                    }
                    yes.setOnClickListener {
                        Toast.makeText(this, "삭제되었습니다.", Toast.LENGTH_SHORT).show()
                    }

                    dialog.show()
                }
            }
            true
        })

        popup.show()
    }
}
