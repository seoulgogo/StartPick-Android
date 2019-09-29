package com.seoulapp.startpick.network.get

data class showResumeData(
        val activity: ArrayList<ActivityData>,
        val career: ArrayList<CareerData>,
        val idx: Int,
        val intro: String?,
        val link: String?,
        val major: String?,
        val name: String?,
        val phone: String?,
        val updatDate: String?,
        val user_idx: Int
)