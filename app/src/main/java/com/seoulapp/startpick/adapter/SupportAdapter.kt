package com.seoulapp.startpick.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.seoulapp.startpick.R
import com.seoulapp.startpick.data.SupportData
import com.seoulapp.startpick.ui.SupportDetailActivity

class SupportAdapter(private val ctx : Context, private val dataList : ArrayList<SupportData>) : RecyclerView.Adapter<SupportAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SupportAdapter.ViewHolder {
        val view: View = LayoutInflater.from(ctx)!!.inflate(R.layout.item_support_inner, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: SupportAdapter.ViewHolder, position: Int) {
        holder.title_tv.text = dataList[position].title
        holder.center_tv.text = dataList[position].center
        holder.data_tv.text = dataList[position].date

        /* 아이템 클릭 이벤트 */
        holder.item.setOnClickListener {
            var intent = Intent(ctx, SupportDetailActivity::class.java)
            ctx.startActivity(intent)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item = itemView as RelativeLayout
        var title_tv = itemView.findViewById(R.id.tv_supportinner_title) as TextView
        var center_tv = itemView.findViewById(R.id.tv_supportinner_center) as TextView
        var data_tv = itemView.findViewById(R.id.tv_supportinner_date) as TextView

    }
}