package com.seoulapp.startpick.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.seoulapp.startpick.R
import com.seoulapp.startpick.data.InfoHomefragData

class InfoHomeAdapter(private val ctx : Context, private val dataList : ArrayList<InfoHomefragData>) : RecyclerView.Adapter<InfoHomeAdapter.Holder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx)!!.inflate(R.layout.item_info_home_frag, viewGroup, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        //glide
        Glide.with(ctx).load(dataList[position].image).into(holder.Image)
        holder.title.text =  dataList[position].title.toString()
        holder.organize.text = dataList[position].organize.toString()
        holder.division.text = dataList[position].division.toString()

    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Image = itemView.findViewById(R.id.img_info_home_frag_item) as ImageView
        var title = itemView.findViewById(R.id.tv_title_info_item) as TextView
        var organize = itemView.findViewById(R.id.tv_organizer_info_item) as TextView
        var division = itemView.findViewById(R.id.tv_division_info_item) as TextView

    }
}