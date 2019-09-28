package com.seoulapp.startpick.network.get

import com.seoulapp.startpick.data.WithusItemData

data class GetWithusFilterResponse(
        val data: ArrayList<WithusItemData>,
        val status: Int,
        val success: Boolean
)