package com.seoulapp.startpick.network.get

data class GetMainNewOrderResponse(
        val data: ArrayList<MainOrderData>,
        val status: Int,
        val success: Boolean
)