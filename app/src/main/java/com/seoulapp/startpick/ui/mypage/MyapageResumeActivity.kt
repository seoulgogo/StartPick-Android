package com.seoulapp.startpick.ui.mypage

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.seoulapp.startpick.R
import com.seoulapp.startpick.data.UserInfoData
import com.seoulapp.startpick.db.SharedPreferenceController
import com.seoulapp.startpick.network.ApplicationController
import com.seoulapp.startpick.network.NetworkService
import com.seoulapp.startpick.network.get.GetMypageUserInfoResponse
import com.seoulapp.startpick.network.get.GetShowResumeResponse
import com.seoulapp.startpick.network.get.showResumeData
import com.seoulapp.startpick.network.post.PostLoginResponse
import kotlinx.android.synthetic.main.activity_myapage_resume.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream

class MyapageResumeActivity : AppCompatActivity() {

    val My_READ_STORAGE_REQUEST_CODE = 88
    private val REQ_CODE_SELECT_IMAGE = 100

    lateinit var selectedImageUri: Uri
    private var imgs: MultipartBody.Part? = null

    var et_phone = false
    var et_resume_theme = false
    var next_btn_activation = false

    var btn_major_arrow = false
    var btn_carrer_arrow = false
    var btn_active_arrow = false
    var btn_introduce = false
    var btn_link_arrow = false

    var phone = ""
    var email = ""
    var name = ""
    var major = ""
    var intro = ""
    var link = ""
    var resume_name = ""

    var c_companyName = ""
    var c_startYear = ""
    var c_startMonth = ""
    var c_endYear = ""
    var c_endMonth = ""
    var c_content = ""

    var a_companyName = ""
    var a_startYear = ""
    var a_startMonth = ""
    var a_endYear = ""
    var a_endMonth = ""
    var a_content = ""

    var flag = -1
    var getid = -1

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myapage_resume)

        setOnClickListener()
        editText()

        UserInfo()

        getid = intent.getIntExtra("getid", -1)
        if(getid == 1)
        {
            resume_name = intent.getStringExtra("name")
            getShowResumeResponse()
        }

        else
            UserInfo()
    }

    fun setOnClickListener() {
        btn_back_mypage_resume_act.setOnClickListener {
            finish()
        }

        img_delete_mypage_resume_act.setOnClickListener {
            if(getid == 1)
                getResumeDelete()
            else
                Toast.makeText(getApplicationContext(), "뒤로가기 버튼을 눌러주세요.", Toast.LENGTH_LONG).show()

        }

        rl_profile_mypage_resume_act.setOnClickListener {
            requestReadExternalStoragePermission()
        }

        btn_store_mypage_resume_act.setOnClickListener {
            if(next_btn_activation)
            {
                major = et_major_mypage_resume_act.text.toString()
                link = et_link_mypage_resume_act.text.toString()
                intro = et_introduce_mypage_resume_act.text.toString()

                c_companyName = et_companyname_mypageresume_act.text.toString()
                c_startYear = et_startyear_mypageresume_act.text.toString()
                c_startMonth = et_startmonth_mypageresume_act.text.toString()
                c_endYear = et_endyear_mypageresume_act.text.toString()
                c_endMonth = et_endmonth_mypageresume_act.text.toString()
                c_content = et_content_mypageresume_act.text.toString()

                a_companyName = et_activityname_mypageresume_act.text.toString()
                a_startYear = et_startyear2_mypageresume_act.text.toString()
                a_startMonth = et_startmonth2_mypageresume_act.text.toString()
                a_endYear = et_endyear2_mypageresume_act.text.toString()
                a_endMonth = et_endmonth2_mypageresume_act.text.toString()
                a_content = et_activitycontent_resumeact.text.toString()

                //##통신
                postResumeStore()

                finish()
            }
        }

        ll_mypage_resume_act.setOnClickListener {
            keyboardDown(ll_mypage_resume_act)
        }

        //전공
        btn_open_major_mypage_resume_act.setOnClickListener{
            if(btn_major_arrow)
            {
                btn_major_arrow = false
                btn_open_major_mypage_resume_act.isSelected = false
                et_major_mypage_resume_act.visibility = View.GONE
            }
            else{
                btn_major_arrow = true
                btn_open_major_mypage_resume_act.isSelected = true
                et_major_mypage_resume_act.visibility = View.VISIBLE
            }
        }

        //경력
        btn_career_mypage_resume_act.setOnClickListener {
            if(btn_carrer_arrow)
            {
                btn_carrer_arrow = false
                btn_career_mypage_resume_act.isSelected = false
                ll_career_mypage_resume_act.visibility = View.GONE
            }
            else{
                btn_carrer_arrow = true
                btn_career_mypage_resume_act.isSelected = true
                ll_career_mypage_resume_act.visibility = View.VISIBLE
            }
        }

        //활동및기타
        btn_active_mypage_resume_act.setOnClickListener {
            if(btn_active_arrow)
            {
                btn_active_arrow = false
                btn_active_mypage_resume_act.isSelected = false
                ll_active_mypage_resume_act.visibility = View.GONE
            }
            else{
                btn_active_arrow = true
                btn_active_mypage_resume_act.isSelected = true
                ll_active_mypage_resume_act.visibility = View.VISIBLE
            }
        }

        //자기소개
        btn_introduce_mypage_resume_act.setOnClickListener {
            if(btn_introduce)
            {
                btn_introduce = false
                btn_introduce_mypage_resume_act.isSelected = false
                et_introduce_mypage_resume_act.visibility = View.GONE
            }
            else{
                btn_introduce = true
                btn_introduce_mypage_resume_act.isSelected = true
                et_introduce_mypage_resume_act.visibility = View.VISIBLE
            }
        }

        //링크
        btn_link_mypage_resume_act.setOnClickListener {
            if(btn_link_arrow)
            {
                btn_link_arrow = false
                btn_link_mypage_resume_act.isSelected = false
                ll_link_mypage_resume_act.visibility = View.GONE
            }
            else{
                btn_link_arrow = true
                btn_link_mypage_resume_act.isSelected = true
                ll_link_mypage_resume_act.visibility = View.VISIBLE
            }
        }

    }

    private fun configurebasicSetting() {
        phone = intent.getStringExtra("phone")
        title = intent.getStringExtra("title")
        major = intent.getStringExtra("major")
        c_content = intent.getStringExtra("name")
        link = intent.getStringExtra("link")

        //이력서를 눌러서 들어오는 경우
        flag = 1

    }

    private fun UserInfo() {
        //이걸로 바꿔줘야함!!!
        //if (SharedPreferenceController.MY_EMAIL.length > 0)
        getMypageUserInfoResponse(SharedPreferenceController.MY_EMAIL)

        //getMypageUserInfoResponse("soso3786@gmail.com")

    }

    //userInfo get함수
    private fun getMypageUserInfoResponse(email: String) {

        val getMypageUserInfoResponse: Call<GetMypageUserInfoResponse> = networkService.getMypageUserInfo(email)

        getMypageUserInfoResponse.enqueue(object : Callback<GetMypageUserInfoResponse> {

            override fun onFailure(call: Call<GetMypageUserInfoResponse>, t: Throwable) {
                Log.e("userinfo get fail", t.toString())
            }

            override fun onResponse(call: Call<GetMypageUserInfoResponse>, response: Response<GetMypageUserInfoResponse>
            ) {
                Log.e("userinfo get success", response.body().toString())

                val temp: UserInfoData = response.body()!!.data
                val status = response.body()!!.status

                if (status == 200) {
                    makeView(temp)
                }
                else
                { }
            }
        })
    }

    //이력서 작성 detail
    fun getShowResumeResponse(){
        val getresumeShowResponse: Call<GetShowResumeResponse> = networkService.getResumeShow(resume_name)

        getresumeShowResponse.enqueue(object : Callback<GetShowResumeResponse> {

            override fun onFailure(call: Call<GetShowResumeResponse>, t: Throwable) {
                Log.e("이력서 detail get fail", t.toString())
            }

            override fun onResponse(call: Call<GetShowResumeResponse>, response: Response<GetShowResumeResponse>
            ) {
                Log.e("이력서 detail get success", response.body().toString())
                val status = response.body()!!.status
                if (status == 200) {

                    val temp: showResumeData = response.body()!!.data

                    makeResumeShowView(temp)
                }
                else if(status == 400)
                {

                }
            }
        })
    }

    //이력서 삭제 함수
    private fun getResumeDelete() {

        val getResumeDelete: Call<PostLoginResponse> = networkService.getResumeDelete(resume_name)

        getResumeDelete.enqueue(object : Callback<PostLoginResponse> {

            override fun onFailure(call: Call<PostLoginResponse>, t: Throwable) {
                Log.e("이력서삭제 fail", t.toString())
            }

            override fun onResponse(call: Call<PostLoginResponse>, response: Response<PostLoginResponse>
            ) {
                Log.e("이력서 삭제 success", response.body().toString())

                val temp: UserInfoData = response.body()!!.data
                val status = response.body()!!.status

                if (status == 200) {
                    Toast.makeText(getApplicationContext(), "삭제되었습니다!", Toast.LENGTH_LONG).show()
                    finish()
                }
                else
                { }
            }
        })
    }

    //resume create post함수
    fun postResumeStore() {

        var carrerJson = JSONObject()
        carrerJson.put("companyName",c_companyName)
        carrerJson.put("startYear",c_startYear)
        carrerJson.put("startMonth",c_startMonth)
        carrerJson.put("endYear",c_endYear)
        carrerJson.put("endMonth",c_endMonth)
        carrerJson.put("content",c_content)
        var activeJson = JSONObject()
        activeJson.put("activityName",c_companyName)
        activeJson.put("startYear",c_startYear)
        activeJson.put("startMonth",c_startMonth)
        activeJson.put("endYear",c_endYear)
        activeJson.put("endMonth",c_endMonth)
        activeJson.put("content",c_content)

        var jsonObject = JSONObject()
        jsonObject.put("email", email)
        jsonObject.put("name", name)
        jsonObject.put("phone", phone)
        jsonObject.put("major", major)
        jsonObject.put("intro", intro)
        jsonObject.put("link",link)
        jsonObject.put("intro", intro)
        jsonObject.put("career",carrerJson)
        jsonObject.put("activity",activeJson)

        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject
        var networkService = networkService.postMyresumeStore(gsonObject)
        networkService.enqueue(object : Callback<PostLoginResponse> {
            override fun onFailure(call: Call<PostLoginResponse>, t: Throwable) {
                Log.e("Login error", t.toString())
            }

            override fun onResponse(call: Call<PostLoginResponse>, response: Response<PostLoginResponse>) {
                if (response.isSuccessful) {
                    val status = response.body()!!.status
                    if (status == 200) {
                        //SharedPreferenceController.setUserToken(applicationContext, response.body()!!.data.token.token)
                        Toast.makeText(getApplicationContext(), "저장되었습니다!", Toast.LENGTH_LONG).show()
                        finish()

                    } else if(status == 400){

                        Toast.makeText(getApplicationContext(), response.body()!!.message, Toast.LENGTH_LONG).show()

                        Log.e("message",response.body()!!.message)
                    }
                }
            }
        })
    }


    private fun makeResumeShowView(data : showResumeData)
    {
        //연락처
        et_phone_mypage_resume_act.setText(data?.phone)
        //이력서제목
        et_resume_theme_mypage_resume_act.setText(data?.name)

        //전공
        if(data.major !="")
        {
            if(btn_major_arrow)
            {
                btn_major_arrow = false
                btn_open_major_mypage_resume_act.isSelected = false
                et_major_mypage_resume_act.visibility = View.GONE
            }
            else{
                btn_major_arrow = true
                btn_open_major_mypage_resume_act.isSelected = true
                et_major_mypage_resume_act.visibility = View.VISIBLE
            }
            //전공
            et_major_mypage_resume_act.setText(data?.major)
        }

        //자기소개
        if(data.intro !="")
        {
            if(btn_introduce)
            {
                btn_introduce = false
                btn_introduce_mypage_resume_act.isSelected = false
                et_introduce_mypage_resume_act.visibility = View.GONE
            }
            else{
                btn_introduce = true
                btn_introduce_mypage_resume_act.isSelected = true
                et_introduce_mypage_resume_act.visibility = View.VISIBLE
            }
            //자기소개
            et_introduce_mypage_resume_act.setText(data?.intro)
        }

        //링크
        if(data.link !="")
        {
            if(btn_link_arrow)
            {
                btn_link_arrow = false
                btn_link_mypage_resume_act.isSelected = false
                ll_link_mypage_resume_act.visibility = View.GONE
            }
            else{
                btn_link_arrow = true
                btn_link_mypage_resume_act.isSelected = true
                ll_link_mypage_resume_act.visibility = View.VISIBLE
            }
            //링크
            et_link_mypage_resume_act.setText(data?.link)
        }

        if(data.career.size !=0)
        {

            if(btn_carrer_arrow)
            {
                btn_carrer_arrow = false
                btn_career_mypage_resume_act.isSelected = false
                ll_career_mypage_resume_act.visibility = View.GONE
            }
            else{
                btn_carrer_arrow = true
                btn_career_mypage_resume_act.isSelected = true
                ll_career_mypage_resume_act.visibility = View.VISIBLE
            }

            //회사명
            et_companyname_mypageresume_act.setText(data.career[0]?.companyName)

            //####startDate를 가공해야함
            //career재직기간 시작
            et_startyear_mypageresume_act.setText(data.career[0]?.startDate)

            //####endDate를 가공해야함
            //career재직기간 끝
            et_startyear_mypageresume_act.setText(data.career[0]?.endDate)

            //career담당업무
            et_content_career_mypage_resume_act.setText(data.career[0]?.content)
        }
        if(data.activity.size !=0){

            if(btn_active_arrow)
            {
                btn_active_arrow = false
                btn_active_mypage_resume_act.isSelected = false
                ll_active_mypage_resume_act.visibility = View.GONE
            }
            else{
                btn_active_arrow = true
                btn_active_mypage_resume_act.isSelected = true
                ll_active_mypage_resume_act.visibility = View.VISIBLE
            }

            //활동
            //활동명
            et_activityname_mypageresume_act.setText(data.activity[0]?.activityName)

            //####startDate를 가공해야함
            //act재직기간 시작
            et_startyear2_mypageresume_act.setText(data.activity[0]?.startDate)

            //####endDate를 가공해야함
            //act재직기간 끝
            et_endmonth2_mypageresume_act.setText(data.activity[0]?.endDate)

            //activity담당업무
            et_activitycontent_resumeact.setText(data.activity[0]?.content)
        }

    }

    private fun makeView(data : UserInfoData)
    {
        //이미지
        //user_porfile
        if (data.img == null)
            Glide.with(this).load(R.drawable.icon_profile).into(img_profile_mypage_resume_act)
        else
            Glide.with(this).load(data.img).into(img_profile_mypage_resume_act)

        //이름
        tv_username_mypageresume_frag.setText(data.name)
        //이메일
        tv_email_mypageresume_frag.setText(data.email)
        email = data.email
        //직업
        tv_major_mypageresume_frag.setText(data.job)

        var gender_string = ""
        //나이, 성별
        if(data.gender == 0)
            gender_string = "남"
        else
            gender_string = "여"

        tv_gender_age_mypageresume_frag.setText("("+gender_string+","+ data.age + ")")
    }

    private fun test(id : View, flag : Boolean, view : View ) {

        var btn_flag = flag

            if(btn_flag)
            {
                btn_flag = false
                id.isSelected = false
                view.visibility = View.GONE
            }
            else{
                btn_flag = true
                id.isSelected = true
                view.visibility = View.VISIBLE
            }
    }

    private fun editText() {

        //연락처
        et_phone_mypage_resume_act.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                phone = et_phone_mypage_resume_act.text.toString()

                if (phone.length > 0) {
                    et_phone = true
                } else {
                    et_phone = false
                }

                if (et_phone) {
                    if (et_resume_theme) {
                        next_btn_activation = true
                        btn_store_mypage_resume_act.setBackgroundResource(R.color.maincolor)
                    }

                }
            }
        })

        //이력서제목
        et_resume_theme_mypage_resume_act.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                 name = et_resume_theme_mypage_resume_act.text.toString()

                if (name.length > 0) {
                    et_resume_theme = true
                } else {
                    et_resume_theme = false
                }

                if (et_resume_theme) {
                    if (et_phone) {
                        next_btn_activation = true
                        btn_store_mypage_resume_act.setBackgroundResource(R.color.maincolor)
                    }
                }
            }
        })
    }

    private fun keyboardDown(view: View) {

        val imm: InputMethodManager = applicationContext!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    //저장소 권한 확인
    private fun requestReadExternalStoragePermission() {

        if (ContextCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) != PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                            this,
                            android.Manifest.permission.READ_EXTERNAL_STORAGE
                    )
            ) {
            } else {
                ActivityCompat.requestPermissions(
                        this,
                        arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                        My_READ_STORAGE_REQUEST_CODE
                )
            }
        } else {
            showAlbum()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == My_READ_STORAGE_REQUEST_CODE) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showAlbum()
            } else {
                finish()
            }
        }
    }

    fun showAlbum() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = android.provider.MediaStore.Images.Media.CONTENT_TYPE
        intent.data = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        startActivityForResult(intent, REQ_CODE_SELECT_IMAGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_CODE_SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {

                    selectedImageUri = data.data!!
                    //Uri를 getRealPathFromURI라는 메소드를 통해 절대 경로를 알아내고, 인스턴스 변수 imageURI에 넣어줍니다!

                    Glide.with(this@MyapageResumeActivity)
                            .load(selectedImageUri)
                            .thumbnail(0.1f)
                            .into(img_profile_mypage_resume_act)

                    val options = BitmapFactory.Options()

                    var input: InputStream? = null // here, you need to get your context.
                    try {
                        input = contentResolver.openInputStream(selectedImageUri)
                    } catch (e: FileNotFoundException) {
                        e.printStackTrace()
                    }

                    val bitmap = BitmapFactory.decodeStream(input, null, options) // InputStream 으로부터 Bitmap 을 만들어 준다.
                    val baos = ByteArrayOutputStream()
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos)

                    val photoBody = RequestBody.create(MediaType.parse("image/jpg"), baos.toByteArray())
                    val photo = File(selectedImageUri.toString()) // 가져온 파일의 이름을 알아내려고 사용합니다

                    imgs = MultipartBody.Part.createFormData("imgs", photo.name, photoBody)

                }
            }
        }
    }

}
