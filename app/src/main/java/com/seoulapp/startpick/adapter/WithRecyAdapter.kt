package com.seoulapp.startpick.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.seoulapp.startpick.R
import com.seoulapp.startpick.data.WithusItemData
import com.seoulapp.startpick.ui.WithDetailActivity



class WithRecyAdapter(private val ctx : Context, val dataList : ArrayList<WithusItemData>) : RecyclerView.Adapter<WithRecyAdapter.Holder>() {

    var isClicked = false

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx)!!.inflate(R.layout.item_job_fragment, viewGroup, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(ctx).load(dataList[position].thumnail).into(holder.thumbnail)
        holder.title.text = dataList[position].detailJob
        holder.company.text = dataList[position].companyName
       // holder.content_detail.text = dataList[position].withUs_idx

        /* 아이템 클릭 이벤트 */
        holder.item.setOnClickListener {
            var intent = Intent(ctx, WithDetailActivity::class.java)
            intent.putExtra("withus_idx", dataList[position].withUs_idx)
            intent.putExtra("withus_idx", dataList[position].withUs_idx)
            ctx.startActivity(intent)
        }
        /* 체크 버튼 클릭 이벤트 */
        // 근데 이거 아님 이상함 두번 눌러야 체크 켜짐,,
        holder.iv_check.setOnClickListener {
            if(isClicked == false) {
                holder.iv_check.isSelected = true
                isClicked = true
            }
            else {
                holder.iv_check.isSelected = false
                isClicked = false
            }
        }
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var item = itemView as RelativeLayout
        var iv_check = itemView.findViewById(R.id.iv_check) as ImageView
        var title = itemView.findViewById(R.id.item_job_fragment_title) as TextView
        var company = itemView.findViewById(R.id.item_job_fragment_company) as TextView
        var thumbnail = itemView.findViewById(R.id.withList_thumbnail) as ImageView
    }

    override fun getItemCount(): Int = dataList.size
}