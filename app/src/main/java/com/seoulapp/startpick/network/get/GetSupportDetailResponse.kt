package com.seoulapp.startpick.network.get

import com.seoulapp.startpick.data.SupportDetailData

data class GetSupportDetailResponse(
        val data: ArrayList<SupportDetailData>,
        val status: Int,
        val success: Boolean
)