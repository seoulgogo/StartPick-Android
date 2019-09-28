package com.seoulapp.startpick.network

import com.google.gson.JsonObject
<<<<<<< HEAD
=======

>>>>>>> a807bb99effbcd4d06726cf4a3c3339d8f8ca99b
import com.seoulapp.startpick.network.get.GetMainNewOrderResponse
import com.seoulapp.startpick.network.get.GetMapPlaceAllResponse
import com.seoulapp.startpick.network.get.GetMypageUserInfoResponse
import com.seoulapp.startpick.network.get.GetShowAllResumeResponse
import com.seoulapp.startpick.network.get.*
import com.seoulapp.startpick.network.post.PostLoginResponse
import com.seoulapp.startpick.network.post.PostSignupResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {

    //로그인
    @POST("auth/signin")
    fun postlogin(
            @Body() body: JsonObject
    ): Call<PostLoginResponse>

    //회원가입
    @Multipart
    @POST("auth/signup")
    fun postSignUp(
            @Part("email") email : RequestBody,
            @Part("pw") pw : RequestBody,
            @Part("name") name : RequestBody,
            @Part("phone") phone : RequestBody,
            @Part("birth") birth : RequestBody,
            @Part("job_idx") job : RequestBody,
            @Part("gender") gender : RequestBody,
            @Part img : MultipartBody.Part?
    ): Call<PostSignupResponse>


    /*home fragment*/

    //방금 올라온 공고
    @GET("main/newOrder")
    fun getMainNewOrder(
    ):Call<GetMainNewOrderResponse>

    //맞춤형공고
    @GET("main/CustomizeOrder/{job_idx}")
    fun getMainCustomizeOrder(
            @Path("job_idx") job_idx : Int
    ):Call<GetMainNewOrderResponse>

    //인기공고
    @GET("main/likeOrder")
    fun getMainlikeOrder(
    ):Call<GetMainNewOrderResponse>



    /*map fragment*/

    //map fragment에서 정보 가져오기
    @GET("place/all")
    fun getMapPlaceAll(
    ): Call<GetMapPlaceAllResponse>

    //map fragment에서 city에 따라 정보 가져오기
    @GET("place/area/{city}")
    fun getPlaceCity(
            @Path("city") city : Int
    ):Call<GetMapPlaceAllResponse>

    @POST("place/distOrder")
    fun postPlaceDistOrderCity(
            @Body() body : JsonObject
    ):Call<GetMapPlaceAllResponse>


    /*mypage fragment*/

    //이력서 작성 저장버튼 통신
    @POST("resume/create")
    fun postMyresumeStore(
            @Body() body: JsonObject
    ):Call<PostLoginResponse>

    //userInfo
    @GET("myPage/userInfo/{email}")
    fun getMypageUserInfo(
           @Path("email") email : String
    ):Call<GetMypageUserInfoResponse>

    //이력서 정보
    @GET("resume/showAllResume/{email}")
    fun getshowAllResume(
            @Path("email") email : String
    ):Call<GetShowAllResumeResponse>

    @GET("myPage/scrape/getScrapsupport/{user_idx}")
    fun getScrapSupport(
            @Path("user_idx") user_idx : Int
    ):Call<GetSupportTabResponse>

    // 함께해요 리스트
    @GET("withUs/all")
    fun getWithList(
    ): Call<GetWithusAllResponse>

    // 함께해요 리스트 필터 적용된 리스트
    @GET("withUs/all/filterWithUs/{startUp_idx}/{job_idx}")
    fun getWithusDetailResponse(
            @Path("startUp_idx") startUp_idx: Int,
            @Path("job_idx") job_idx : Int
    ): Call<GetWithusFilterResponse>

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




}