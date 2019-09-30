package com.seoulapp.startpick.network.post

import com.seoulapp.startpick.data.UserIdxData

data class PostSignupResponse(
    val message: String,
    val status: Int,
    val success: Boolean,
    val data : UserIdxData
)