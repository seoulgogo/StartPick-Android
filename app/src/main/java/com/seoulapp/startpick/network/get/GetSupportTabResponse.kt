package com.seoulapp.startpick.network.get

import com.seoulapp.startpick.data.SupportItemData

data class GetSupportTabResponse(
        val data: ArrayList<SupportItemData>,
        val status: Int,
        val success: Boolean
)