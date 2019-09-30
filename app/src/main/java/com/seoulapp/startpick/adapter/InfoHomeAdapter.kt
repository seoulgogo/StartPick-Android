package com.seoulapp.startpick.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.seoulapp.startpick.R
import com.seoulapp.startpick.data.MainOrderData
import com.seoulapp.startpick.ui.WithDetailActivity
import org.jetbrains.anko.startActivity

class InfoHomeAdapter(private val ctx : Context, val dataList : ArrayList<MainOrderData>) : RecyclerView.Adapter<InfoHomeAdapter.Holder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx)!!.inflate(R.layout.item_info_home_frag, viewGroup, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        var startUp : ArrayList<String> = arrayListOf("IT", "여행", "교육", "금융", "보안", "교통", "건설",
                "게임", "부동산", "친환경", "헬스케어", "사회봉사", "자연과학", "전자제품", "물류/유통",
                "광고/마케팅", "농/축/수산업", "엔터테인먼트", "바이오/의료", "기타")


        var startup_idx : Int= dataList[position].startUp_idx

        //glide
        Glide.with(ctx).load(dataList[position].thumnail).into(holder.Image)

        //직무
        if(dataList[position].detailJob == null)
            holder.title.text = "없음"
        else
            holder.title.text =  dataList[position].detailJob.toString()

        //회사명
        if(dataList[position].companyName == null)
            holder.organize.text = "없음"
        else
            holder.organize.text = dataList[position].companyName.toString()

        //startUp_idx
        holder.division.text = startUp[startup_idx-1]

        holder.container.setOnClickListener {
            ctx.startActivity<WithDetailActivity>(
                    "withUs_idx" to dataList[position].withUs_idx
            )
        }
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Image = itemView.findViewById(R.id.img_info_home_frag_item) as ImageView
        var title = itemView.findViewById(R.id.tv_title_info_item) as TextView
        var organize = itemView.findViewById(R.id.tv_organizer_info_item) as TextView
        var division = itemView.findViewById(R.id.tv_division_info_item) as TextView
        var container = itemView.findViewById(R.id.ll_home_frag_container) as LinearLayout


    }
}