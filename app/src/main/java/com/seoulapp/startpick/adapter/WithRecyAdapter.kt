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
        when (dataList[position].job_idx){
            1 -> holder.job.text = "개발"
            2 -> holder.job.text = "기획"
            3 -> holder.job.text = "디자인"
            4 -> holder.job.text = "마케팅"
            5 -> holder.job.text = "미디어"
            6 -> holder.job.text = "영업"
            7 -> holder.job.text = "기타"
        }


        /** 각 아이템 클릭 이벤트 */
        holder.item.setOnClickListener {
            var intent = Intent(ctx, WithDetailActivity::class.java)
            intent.putExtra("withUs_idx", dataList[position].withUs_idx)
            ctx.startActivity(intent)
        }

        /** 체크 버튼 클릭 이벤트 */
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
        var item = itemView as RelativeLayout                                                   // 각 아이템 변수
        var iv_check = itemView.findViewById(R.id.iv_check) as ImageView                        // 체크 이미지 변수
        var title = itemView.findViewById(R.id.item_job_fragment_title) as TextView             // 함께해요 제목 변수
        var company = itemView.findViewById(R.id.item_job_fragment_company) as TextView         // 함께해요 회사 변수
        var thumbnail = itemView.findViewById(R.id.withList_thumbnail) as ImageView             // 함께해요 썸네일 변수
        var job = itemView.findViewById(R.id.tvWithusItem_Job) as TextView                      // 함께해요 직무 변수
    }

    override fun getItemCount(): Int = dataList.size
}