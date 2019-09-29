package com.seoulapp.startpick.network.get

data class GetShowResumeResponse(
        val data: showResumeData,
        val message: String,
        val status: Int,
        val success: Boolean
)