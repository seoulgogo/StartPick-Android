package com.seoulapp.startpick.ui.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.seoulapp.startpick.R
import com.seoulapp.startpick.data.InfoMapfragData
import com.seoulapp.startpick.data.MapGetData
import org.jetbrains.anko.support.v4.ctx

class InfoMapAdapter(val ctx: Context, val dataList: ArrayList<MapGetData>) : RecyclerView.Adapter<InfoMapAdapter.Holder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewtype: Int): Holder {
        val view: View = LayoutInflater.from(ctx)!!.inflate(R.layout.item_info_map_frag, viewGroup, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //glide
        if(dataList[position].s3 == "")
            Glide.with(ctx).load(R.drawable.img_map_loading).into(holder.Image)
        else
            Glide.with(ctx).load(dataList[position].s3).into(holder.Image)
        holder.support_center.text =  dataList[position].agency.toString()
        holder.center_name.text = dataList[position].theme.toString()
        holder.address.text = dataList[position].address.toString()

        if(dataList[position].phone == "")
            holder.phone.text = "전화번호 없음"
        else
            holder.phone.text = dataList[position].phone

        if(dataList[position].url.toString() == ""){
            holder.url.text = "url 없음"
        }
        else
            holder.url.text = dataList[position].url.toString()


        //container를 클릭하면 전화번호부로 이동하기!! 만약 없다면..?
        holder.container.setOnClickListener {

            var tel  : Uri = Uri.parse("tel:"+dataList[position].phone)
            if(dataList[position].phone == "")
                Toast.makeText(ctx, "번호를 읽을 수 없습니다.", Toast.LENGTH_SHORT).show()
            else
            {
                var intent = Intent(Intent.ACTION_DIAL, tel)
                ctx.startActivity(intent)
            }
        }
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var container = itemView.findViewById(R.id.rl_container_item_info_map_frag) as RelativeLayout
        var Image = itemView.findViewById(R.id.img_suport_map_frag) as ImageView
        var support_center = itemView.findViewById(R.id.tv_support_center_map_frag) as TextView
        var center_name = itemView.findViewById(R.id.tv_support_organize_map_frag) as TextView
        var address = itemView.findViewById(R.id.tv_address_map_frag) as TextView
        var url = itemView.findViewById(R.id.tv_url_map_frag) as TextView
        var phone = itemView.findViewById(R.id.tv_phone_map_frag) as TextView
    }

}