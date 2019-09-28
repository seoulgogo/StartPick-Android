package com.seoulapp.startpick.network.get

import com.seoulapp.startpick.data.UserInfoData

data class GetMypageUserInfoResponse(
        val data: UserInfoData,
        val message: String,
        val status: Int,
        val success: Boolean
)