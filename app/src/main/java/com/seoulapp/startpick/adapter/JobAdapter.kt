package com.seoulapp.startpick.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.seoulapp.startpick.R
import com.seoulapp.startpick.data.JobData

class JobAdapter(private val ctx : Context, private val dataList : ArrayList<JobData>) :
        RecyclerView.Adapter<JobAdapter.Holder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx)!!.inflate(R.layout.item_job_fragment, viewGroup, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.content_title.text = dataList[position].title
        holder.content_location.text = dataList[position].location
        holder.content_detail.text = dataList[position].content
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var content_title = itemView.findViewById(R.id.item_job_fragment_title) as TextView
        var content_location = itemView.findViewById(R.id.item_job_fragment_location) as TextView
        var content_detail = itemView.findViewById(R.id.item_job_fragment_detail_tv) as TextView
    }

    override fun getItemCount(): Int = dataList.size
}