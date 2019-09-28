package com.seoulapp.startpick.network

import com.google.gson.JsonObject
import com.seoulapp.startpick.network.get.*
import com.seoulapp.startpick.network.post.PostLoginResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {

    //map fragment에서 정보 가져오기
    @GET("place/all")
    fun getMapPlaceAll(
    ): Call<GetMapPlaceAllResponse>

    @POST("auth/signin")
    fun postlogin(
            @Body() body: JsonObject
    ): Call<PostLoginResponse>

    // 함께해요 전체 리스트
    @GET("withUs/all")
    fun getWithusAllResponse(
    ): Call<GetWithusAllResponse>

    // 함께해요 리스트 필터 적용된 리스트
    @GET("withUs/all/filterWithUs/{startUp_idx}/{job_idx}")
    fun getWithusFilterResponse(
            @Path("startUp_idx") startUp_idx: Int,
            @Path("job_idx") job_idx : Int
    ): Call<GetWithusFilterResponse>

    // 함께해요 각 아이템 디테일 데이터
    @GET("withUs/all/detailAll/{withUs_idx}")
    fun getWithusDetailResponse(
            @Path("withUs_idx") withUs_idx: Int
    ): Call<GetWithusDetailResponse>

    // 지원사업 전체 리스트
    @GET("supportList/all")
    fun getSupportList(
    ): Call<GetSupportListAll>

    // 지원사업 탭별 리스트
    @GET("supportList/all/typeAll/{bsCategory_idx}")
    fun getSupportTabResponse(
            @Path("bsCategory_idx") bsCategory_idx: Int
    ): Call<GetSupportTabResponse>

    // 지원사업 리스트 상세보기
    @GET("supportList/all/detailAll/{business_idx}")
    fun getSupportDetailResponse(
            @Path("business_idx") business_idx: Int
    ): Call<GetSupportDetailResponse>

    // 지원사업 글쓰기 포스트
    @Multipart
    @POST("withUs/insertWithUs")
    fun postWithusApply(
            @Part("user_idx") user_idx : RequestBody,
            @Part("startUp_idx") startUp_idx : RequestBody,
            @Part("job_idx") job_idx : RequestBody,
            @Part("detailJob") detailJob : RequestBody,
            @Part("recrutNum") recrutNum : RequestBody,
            @Part("salary") salary : RequestBody,
            @Part("city_idx") city_idx : RequestBody,
            @Part("mainTask") mainTask : RequestBody,
            @Part("intro") intro : RequestBody,
            @Part("companyName") companyName : RequestBody,
            @Part("managerName") managerName : RequestBody,
            @Part("managerPhone") managerPhone : RequestBody,
            @Part("managerEmail") managerEmail : RequestBody,
            @Part img : MultipartBody.Part?
    ): Call<PostLoginResponse>




}