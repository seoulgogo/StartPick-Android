package com.seoulapp.startpick.ui.adapter

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.seoulapp.startpick.R
import com.seoulapp.startpick.data.ReceivedSupportData
import com.seoulapp.startpick.data.ResumeData
import com.seoulapp.startpick.ui.mypage.MyapageResumeActivity
import org.jetbrains.anko.activityManager
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class ResumeAdapter  (private val ctx : Context, private val dataList : ArrayList<ResumeData>) :
        RecyclerView.Adapter<ResumeAdapter.Holder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx)!!.inflate(R.layout.item_resume_mypage_rv, viewGroup, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = dataList[position].name
        holder.updatDate.text = "최근 수정일 : "+dataList[position].updatDate

        holder.item.setOnClickListener {
            ctx.startActivity<MyapageResumeActivity>(
                    "idx" to dataList[position].idx,
                    "phone" to dataList[position].phone,
                    "major" to dataList[position].major,
                    "name" to dataList[position].name,
                    "intro" to dataList[position].intro,
                    "link" to dataList[position].link,
                    "getid" to 1
            )
        }
    }

    override fun getItemCount(): Int = dataList.size

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item = itemView.findViewById(R.id.ll_container_resume_mp_fg) as LinearLayout
        var title = itemView.findViewById(R.id.tv_resume_title_resume_mp_fg) as TextView
        var updatDate = itemView.findViewById(R.id.tv_resume_edit_resume_mp_fg) as TextView
    }
}