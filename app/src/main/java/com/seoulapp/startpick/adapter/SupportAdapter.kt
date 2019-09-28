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
import com.seoulapp.startpick.data.SupportItemData
import com.seoulapp.startpick.ui.SupportDetailActivity

class SupportAdapter(private val ctx : Context, val dataList : ArrayList<SupportItemData>) : RecyclerView.Adapter<SupportAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SupportAdapter.ViewHolder {
        val view: View = LayoutInflater.from(ctx)!!.inflate(R.layout.item_support, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: SupportAdapter.ViewHolder, position: Int) {
        holder.title.text = dataList[position].bsName
        holder.agency.text = dataList[position].agency
        holder.date.text = dataList[position].endDate

        /* 아이템 클릭 이벤트 */
        holder.item.setOnClickListener {
            var intent = Intent(ctx, SupportDetailActivity::class.java)
            intent.putExtra("bs_idx", dataList[position].business_idx)
            ctx.startActivity(intent)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item = itemView as RelativeLayout
        var title = itemView.findViewById(R.id.tv_supportinner_title) as TextView
        var agency = itemView.findViewById(R.id.tv_supportinner_center) as TextView
        var date = itemView.findViewById(R.id.tv_supportinner_date) as TextView
    }
}