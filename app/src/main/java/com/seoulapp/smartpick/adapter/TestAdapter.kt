package com.seoulapp.smartpick.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.seoulapp.smartpick.R
import com.seoulapp.smartpick.data.TestData
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.jetbrains.anko.startActivity

class TestAdapter(private val ctx : Context, private val dataList : ArrayList<TestData>) : RecyclerView.Adapter<TestAdapter.Holder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx)!!.inflate(R.layout.item_home_fragment, viewGroup, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.test1.text = "추천" + dataList[position].test1.toString()
        holder.test2.text = "댓글" + dataList[position].test2.toString()
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var test1 = itemView.findViewById(R.id.rv_test1) as TextView
        var test2 = itemView.findViewById(R.id.rv_test2) as TextView


    }
}