package com.seoulapp.smartpick.ui

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.seoulapp.smartpick.R
import com.seoulapp.smartpick.data.InfoHomefragData
import com.seoulapp.smartpick.data.InfoMapfragData
import com.seoulapp.smartpick.ui.adapter.InfoHomeAdapter
import com.seoulapp.smartpick.ui.adapter.InfoMapAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_map.*


class MapFragment : Fragment() {

    private lateinit var rootView: View
    lateinit var mapAdapter: InfoMapAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_map, container, false)


        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setRecyclerView()
    }

    fun setRecyclerView() {
        var mapInfoData : ArrayList<InfoMapfragData> = ArrayList()

        mapInfoData.add(InfoMapfragData("DMC 창업센터", "시창업센터", "서울시 노원구 공릉동 맞춰ㅏ라!", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD","02-31628-1111", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD"))
        mapInfoData.add(InfoMapfragData("DMC 창업센터", "시창업센터", "서울시 노원구 공릉동 맞춰ㅏ라!", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD","02-31628-1111", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD"))
        mapInfoData.add(InfoMapfragData("DMC 창업센터", "시창업센터", "서울시 노원구 공릉동 맞춰ㅏ라!", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD","02-31628-1111", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD"))
        mapInfoData.add(InfoMapfragData("DMC 창업센터", "시창업센터", "서울시 노원구 공릉동 맞춰ㅏ라!", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD","02-31628-1111", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD"))
        mapInfoData.add(InfoMapfragData("DMC 창업센터", "시창업센터", "서울시 노원구 공릉동 맞춰ㅏ라!", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD","02-31628-1111", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD"))
        mapInfoData.add(InfoMapfragData("DMC 창업센터", "시창업센터", "서울시 노원구 공릉동 맞춰ㅏ라!", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD","02-31628-1111", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD"))
        mapInfoData.add(InfoMapfragData("DMC 창업센터", "시창업센터", "서울시 노원구 공릉동 맞춰ㅏ라!", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD","02-31628-1111", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD"))

        mapAdapter = InfoMapAdapter(activity!!, mapInfoData)
        //맞춤형
        rv_seoul_startup_info_map_frag.adapter = mapAdapter
        rv_seoul_startup_info_map_frag.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

    }
}
