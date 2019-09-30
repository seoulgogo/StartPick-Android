package com.seoulapp.startpick.network

import com.google.gson.JsonObject
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
            @Part("job") job : RequestBody,
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


    //마이페이지.스크랩.지원사업
    @GET("myPage/scrape/getScrapsupport/{user_idx}")
    fun getScrapSupport(
            @Path("user_idx") user_idx : Int
    ):Call<GetSupportTabResponse>

    //마이페이지.스크랩.구인구직
    @GET("myPage/scrape/getScrapWithUs/{user_idx}")
    fun getScrapWithUs(
            @Path("user_idx") user_idx : Int
    ):Call<GetWithusAllResponse>

    //지원현황.받은지원
    @GET("apply/application/{email}")
    fun getMypageApplication(
            @Path("email") email : String
    ):Call<GetSupportApplicationResponse>

    //지원현황.보낸지원
    @GET("apply/myApply/{email}")
    fun getMyApply(
            @Path("email") email: String
    ):Call<GetSupportStatemyApplyResponse>

    //이미지변경
    @Multipart
    @POST("auth/changeImg")
    fun postImgChange(
            @Part("email") email : RequestBody,
            @Part img : MultipartBody.Part?
    ):Call<PostSignupResponse>

    //이력서선택-->이력서 뿌려주기
    @GET("resume/showResume/{resumeName}")
    fun getResumeShow(
            @Path("resumeName") resumeName : String
    ):Call<GetShowResumeResponse>

    //내가 올린 공고
    @GET("myPage/scrape/getMyWithUs/{user_idx}")
    fun getMypagegetMyWithus(
            @Path("user_idx") user_idx : Int
    ):Call<GetWithusAllResponse>

    //이력서 삭제
    @GET("resume/delete")
    fun getResumeDelete(
            @Query("name") name : String
    ):Call<PostLoginResponse>




    /* 함께해요 fragment */

    // 함께해요 리스트

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


    /* 지원사업 리스트 */

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

    // 함께해요 글쓰기 포스트
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

    // 함께해요 공고 삭제하기
    @Multipart
    @POST("withUs/withUsDelete")
    fun postWithusDeleteResponse(
            @Part("withUs_idx") withUs_idx : RequestBody
    ): Call<PostLoginResponse>

    // 함께해요 최신순 GET 통신
    @GET("withUs/order/newOrder")
    fun getWithusNeworderResponse(
    ): Call<GetWithusAllResponse>


    // 함께해요 인기순 GET 통신
    @GET("withUs/order/likeOrder")
    fun getWithusLikeorderResponse(
    ): Call<GetWithusAllResponse>

    // 지원사업 등록일순 GET 통신
    @GET("supportList/order/enrollOrder")
    fun getSupportEnrollorderResponse(
    ): Call<GetSupportListAll>

    // 지원사업 마감일순 GET 통신
    @GET("supportList/order/endOrder")
    fun getSupportEndorderResponse(
    ): Call<GetSupportListAll>

    // 지원사업 최신순 GET 통신
    @GET("supportList/order/startOrder")
    fun getSupportStartorderResponse(
    ): Call<GetSupportListAll>



}