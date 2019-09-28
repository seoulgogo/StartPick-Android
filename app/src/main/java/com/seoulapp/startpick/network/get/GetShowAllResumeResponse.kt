package com.seoulapp.startpick.network.get

import com.seoulapp.startpick.data.ResumeShowData

data class GetShowAllResumeResponse(
        val data: ArrayList<ResumeShowData>,
        val status: Int,
        val success: Boolean
)