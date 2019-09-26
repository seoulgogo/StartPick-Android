package com.seoulapp.startpick.data

data class MapGetData(
    val address: String,
    val agency: String,
    val city: Int,
    val idx: Int,
    val latitude: Double,
    val longitude: Double,
    val phone: String,
    val s3: String,
    val theme: String,
    val url: String?
)