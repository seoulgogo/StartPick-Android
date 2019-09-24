package com.seoulapp.startpick.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.seoulapp.startpick.R
import com.seoulapp.startpick.data.ReceivedSupportData

class ReceivedSupportAdapter (private val ctx : Context, private val dataList : ArrayList<ReceivedSupportData>) :
        RecyclerView.Adapter<ReceivedSupportAdapter.Holder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx)!!.inflate(R.layout.item_earn_support_mypage_support_fragment, viewGroup, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = dataList[position].title
        holder.name.text = dataList[position].name

        /* 아이템 클릭 이벤트 */
        holder.item.setOnClickListener {
            //
        }
    }

    override fun getItemCount(): Int = dataList.size

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item = itemView.findViewById(R.id.rl_container_support_mp_fg) as RelativeLayout
        var title = itemView.findViewById(R.id.tv_resume_name_support_mp_fg) as TextView
        var name = itemView.findViewById(R.id.tv_resume_name_support_mp_fg) as TextView
    }
}