package com.seoulapp.startpick.util

import android.app.Dialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.seoulapp.startpick.R
import kotlinx.android.synthetic.main.custom_dialog_ready.*

class CustomDialogReady  (context: Context,
                          private val mContent: String,
                          private val mResponseClickListener: View.OnClickListener?, private val responseText: String) : Dialog(context, android.R.style.Theme_Translucent_NoTitleBar) {

    private val clickedState = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val lpWindow = WindowManager.LayoutParams()
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND
        lpWindow.dimAmount = 0.55f
        window!!.attributes = lpWindow


        setContentView(R.layout.custom_dialog_ready)

        tv_ready_custom_dia.text = mContent
        tv_confirm_custom_dialog_ready.text = responseText


        if(mResponseClickListener != null){
            ll_btn_confirm_custom_dia.setOnClickListener(mResponseClickListener)
        }
    }
}
