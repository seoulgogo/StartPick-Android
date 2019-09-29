package com.seoulapp.startpick.network.post

import com.seoulapp.startpick.data.UserInfoData


data class PostLoginResponse(
    val status: Int,
    val success: Boolean,
    val message : String,
    val data : UserInfoData
)