package com.seoulapp.startpick.network.get

import com.seoulapp.startpick.data.ApplicationData

data class GetSupportApplicationResponse(
        val data: ArrayList<ApplicationData>,
        val message: String,
        val status: Int,
        val success: Boolean
)