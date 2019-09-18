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
import com.seoulapp.startpick.data.InfoMapfragData

class InfoMapAdapter(private val ctx: Context, private val dataList: ArrayList<InfoMapfragData>) : RecyclerView.Adapter<InfoMapAdapter.Holder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewtype: Int): Holder {
        val view: View = LayoutInflater.from(ctx)!!.inflate(R.layout.item_info_map_frag, viewGroup, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //glide
        Glide.with(ctx).load(dataList[position].image).into(holder.Image)
        holder.support_center.text =  dataList[position].title.toString()
        holder.center_name.text = dataList[position].center_name.toString()
        holder.address.text = dataList[position].address.toString()
        holder.url.text = dataList[position].url.toString()
        holder.phone.text = dataList[position].phone
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Image = itemView.findViewById(R.id.img_suport_map_frag) as ImageView
        var support_center = itemView.findViewById(R.id.tv_support_center_map_frag) as TextView
        var center_name = itemView.findViewById(R.id.tv_support_organize_map_frag) as TextView
        var address = itemView.findViewById(R.id.tv_address_map_frag) as TextView
        var url = itemView.findViewById(R.id.tv_url_map_frag) as TextView
        var phone = itemView.findViewById(R.id.tv_phone_map_frag) as TextView
    }

}