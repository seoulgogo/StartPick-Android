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

class ResumeAdapter  (private val ctx : Context, private val dataList : ArrayList<ReceivedSupportData>) :
        RecyclerView.Adapter<ResumeAdapter.Holder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx)!!.inflate(R.layout.item_resume_mypage_rv, viewGroup, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = dataList[position].title
        holder.name.text = dataList[position].name
    }

    override fun getItemCount(): Int = dataList.size

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item = itemView.findViewById(R.id.ll_container_resume_mp_fg) as LinearLayout
        var title = itemView.findViewById(R.id.tv_resume_title_resume_mp_fg) as TextView
        var name = itemView.findViewById(R.id.tv_resume_edit_resume_mp_fg) as TextView
    }
}