package com.seoulapp.startpick.network

import com.google.gson.JsonObject
import com.seoulapp.startpick.network.get.GetMapPlaceAllResponse
import com.seoulapp.startpick.network.post.PostLoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NetworkService {

    //map fragment에서 정보 가져오기
    @GET("place/all")
    fun getMapPlaceAll(
    ): Call<GetMapPlaceAllResponse>

    @POST("auth/signin")
    fun postlogin(
            @Body() body: JsonObject
    ): Call<PostLoginResponse>




}