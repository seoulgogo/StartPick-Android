package com.seoulapp.startpick.network.get

import com.seoulapp.startpick.data.MapGetData

data class GetMapPlaceAllResponse(
        val data: ArrayList<MapGetData>,
        val message: String,
        val status: Int,
        val success: Boolean
)