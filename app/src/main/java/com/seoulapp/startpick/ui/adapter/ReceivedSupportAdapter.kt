package com.seoulapp.startpick.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.seoulapp.startpick.R
import com.seoulapp.startpick.data.ApplicationData
import com.seoulapp.startpick.data.ReceivedSupportData

class ReceivedSupportAdapter (private val ctx : Context, val dataList : ArrayList<ApplicationData>) :
        RecyclerView.Adapter<ReceivedSupportAdapter.Holder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx)!!.inflate(R.layout.item_earn_support_mypage_support_fragment, viewGroup, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.title.text = dataList[position].resumeName
        holder.name.text = dataList[position].userName
        holder.company_name.text = "[" + dataList[position].jobIdx+"_" + dataList[position].companyName +"]"



        //glide
        if(dataList[position].img == "")
            Glide.with(ctx).load(R.drawable.img_map_loading).into(holder.img)
        else
            Glide.with(ctx).load(dataList[position].img).into(holder.img)

        /* 아이템 클릭 이벤트 */
        holder.item.setOnClickListener {
            //##넘겨줘야할 뷰
        }
    }

    override fun getItemCount(): Int = dataList.size

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item = itemView.findViewById(R.id.rl_container_support_mp_fg) as RelativeLayout
        var title = itemView.findViewById(R.id.tv_resume_name_support_mp_fg) as TextView
        var name = itemView.findViewById(R.id.tv_resume_name_support_mp_fg) as TextView
        var company_name = itemView.findViewById(R.id.tv_resume_companyName_mp_fg) as TextView
        var img = itemView.findViewById(R.id.img_profile_recyclerview_item) as ImageView
    }
}