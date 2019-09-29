package com.seoulapp.startpick.network.get

import com.seoulapp.startpick.data.MainOrderData

data class GetMainNewOrderResponse(
        val data: ArrayList<MainOrderData>,
        val status: Int,
        val success: Boolean
)