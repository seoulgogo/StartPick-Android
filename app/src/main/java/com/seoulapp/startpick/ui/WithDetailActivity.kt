package com.seoulapp.startpick.ui

import android.app.AlertDialog
import android.app.ProgressDialog.show
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import com.seoulapp.startpick.R
import kotlinx.android.synthetic.main.activity_with_detail.*





class WithDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_detail)

        // statusbarTransparency() // 상태바 투명
        btn_back.setOnClickListener {
            finish()
        }
        three_point.setOnClickListener {
            showPopup(three_point)
        }



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
                    val builder = AlertDialog.Builder(this)
                    val dialogView = layoutInflater.inflate(R.layout.custom_dialog, null)
                    val dialogNo = dialogView.findViewById<TextView>(R.id.no)
                    val dialogYes = dialogView.findViewById<TextView>(R.id.yes)

                    builder.setView(dialogView).setNegativeButton("취소"){
                        dialogInterface, i ->
                    }.setPositiveButton("확인"){
                        dialogInterface, i -> Toast.makeText(this, "취소되었습니다.", Toast.LENGTH_SHORT).show()
                    }.show()
                }
            }
            true
        })

        popup.show()
    }
}
