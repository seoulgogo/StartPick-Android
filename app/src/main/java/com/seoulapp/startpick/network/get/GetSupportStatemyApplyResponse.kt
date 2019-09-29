package com.seoulapp.startpick.network.get

import com.seoulapp.startpick.data.MyApplyData

data class GetSupportStatemyApplyResponse(
        val data: MyApplyData,
        val message: String,
        val status: Int,
        val success: Boolean
)