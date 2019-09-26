package com.seoulapp.startpick.network.post

data class PostLoginResponse(
    val status: Int,
    val success: Boolean,
    val message : String
)