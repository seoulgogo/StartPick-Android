package com.seoulapp.startpick.network.get

import com.seoulapp.startpick.data.WithusDetailData

data class GetWithusDetailResponse(
        val data: ArrayList<WithusDetailData>,
        val status: Int,
        val success: Boolean
)