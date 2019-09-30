package com.seoulapp.startpick.ui

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.InputType
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.bumptech.glide.Glide
import com.isapanah.awesomespinner.AwesomeSpinner
import com.seoulapp.startpick.R
import com.seoulapp.startpick.db.SharedPreferenceController
import com.seoulapp.startpick.network.ApplicationController
import com.seoulapp.startpick.network.NetworkService
import com.seoulapp.startpick.network.post.PostLoginResponse
import kotlinx.android.synthetic.main.activity_myapage_resume.*
import kotlinx.android.synthetic.main.activity_with_detail.*
import kotlinx.android.synthetic.main.activity_write.*
import kotlinx.android.synthetic.main.fragment_job.*
import kotlinx.android.synthetic.main.fragment_mypage.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.jetbrains.anko.ctx
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.textColor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Multipart
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream

class WriteActivity : AppCompatActivity() {

    val My_READ_STORAGE_REQUEST_CODE = 88
    private val REQ_CODE_SELECT_IMAGE = 100
    lateinit var selectedImageUri : Uri
    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }
    var city : Int = 0
    var startup : Int = 0

    /** 함께해요 글쓰기 데이터 변수들 */
    var user_idx : Int = 0
    var job_idx : Int = 0
    lateinit var detailJob : String
    var recrutNum : Int = 0
    lateinit var salary : String
    var nego : Int = 0
    var city_idx : Int = 0
    lateinit var mainTask : String
    lateinit var intro : String
    private var img : MultipartBody.Part? = null
    lateinit var companyName : String
    var startUp_idx : Int = 0
    lateinit var managerName : String
    lateinit var managerPhone : String
    lateinit var managerEmail : String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        back_arrow.setOnClickListener { finish() } // 뒤로가기 버튼 세팅

        // 근무지역 필터 클릭시 화면 전환
        btn_worearea.setOnClickListener {
            var intent = Intent(this, WorkAreaActivity::class.java)
            startActivityForResult(intent, 3000)
        }

        // 스타트업 필터 클릭시 화면 전환
        btn_company.setOnClickListener {
            var intent = Intent(this, StartupDivActivity::class.java)
            startActivityForResult(intent, 3000)
        }

        JobSpinner()        // 직무 스피너 세팅
        PersonSpinner()     // 모집인원 스피너 세팅
        isSelectRadioBtn()  // 추후 협상 가능 세팅

        iv_thumbnail.setOnClickListener {
            requestReadExternalStoragePermission()
        }

        // 작성완료 버튼 클릭 이벤트
        btn_complete.setOnClickListener {
            detailJob = etWithusWriteDetailjob.text.toString()  // 상세 직무 입력 세팅
            salary = etWithusWriteSalary.text.toString()        // 월급 입력 세팅
            mainTask = etWithusWriteDetailMaintask.text.toString()   // 주요 업무 세팅
            intro = etWithusWriteIntro.text.toString()               // 상세 소개 세팅
            companyName = etWithusWriteCompanynm.text.toString()     // 회사명 세팅
            managerName = etWithusWriteDetailManagernm.text.toString() // 담당자 이름 세팅
            managerPhone = etWithusWriteDetailPhone.text.toString()  // 연락처 세팅
            managerEmail = etWithusWriteDetailEmail.text.toString()  // 이메일 세팅
            postWithusApplyResponse()
        }

    }




    /** 직무 스피너 세팅 */
    fun JobSpinner() {

        var spinner = findViewById(R.id.selectJob) as AwesomeSpinner

        var spinnerArray = ArrayList<String>()
        spinnerArray.add("개발")
        spinnerArray.add("기획")
        spinnerArray.add("디자인")
        spinnerArray.add("마케팅")
        spinnerArray.add("미디어")
        spinnerArray.add("영업")
        spinnerArray.add("기타")

        val categoriesAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray)

        spinner.setAdapter(categoriesAdapter)
        spinner.setOnSpinnerItemClickListener(
                AwesomeSpinner.onSpinnerItemClickListener { position, itemAtPosition ->
                    job_idx = position + 1
                })
    }

    /** 모집인원 스피너 세팅 */
    fun PersonSpinner() {

        var spinner = findViewById(R.id.selectPerson) as AwesomeSpinner

        var spinnerArray = ArrayList<String>()
        spinnerArray.add("1명")
        spinnerArray.add("2명")
        spinnerArray.add("3명")
        spinnerArray.add("4명")
        spinnerArray.add("5명")
        spinnerArray.add("미정")

        val categoriesAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray)

        spinner.setAdapter(categoriesAdapter)
        spinner.setOnSpinnerItemClickListener(
                AwesomeSpinner.onSpinnerItemClickListener { position, itemAtPosition ->
                    when(position){
                        0 -> recrutNum = 1
                        1 -> recrutNum = 2
                        2 -> recrutNum = 3
                        3 -> recrutNum = 4
                        4 -> recrutNum = 5
                        5 -> recrutNum = 0  // 미정
                    }
                })
    }

    /** 추후 협상 가능 세팅 */
    fun isSelectRadioBtn(){
        etWithusWriteNego.setOnClickListener {
            if(etWithusWriteNego.isChecked){
                nego = 1
                containerSalary.visibility = View.GONE
            }else{
                nego = 0
                containerSalary.visibility = View.VISIBLE
            }
        }
    }


    /** 네트워크 설정 파일에 있는 함수 */
    /** 함께해요 공고 작성 포스트 */
    fun postWithusApplyResponse(){

        var user_idx = RequestBody.create(MediaType.parse("text/plain"), user_idx.toString())
        var startUp_idx = RequestBody.create(MediaType.parse("text/plain"), startup.toString())
        var job_idx = RequestBody.create(MediaType.parse("text/plain"), job_idx.toString())
        var detailJob = RequestBody.create(MediaType.parse("text/plain"), detailJob)
        var recrutNum = RequestBody.create(MediaType.parse("text/plain"), recrutNum.toString())
        var salary = RequestBody.create(MediaType.parse("text/plain"), salary)
        var city_idx = RequestBody.create(MediaType.parse("text/plain"), city.toString())
        var mainTask = RequestBody.create(MediaType.parse("text/plain"), mainTask)
        var intro = RequestBody.create(MediaType.parse("text/plain"), intro)
        var companyName = RequestBody.create(MediaType.parse("text/plain"), companyName)
        var managerName = RequestBody.create(MediaType.parse("text/plain"), managerName)
        var managerPhone = RequestBody.create(MediaType.parse("text/plain"), managerPhone)
        var managerEmail = RequestBody.create(MediaType.parse("text/plain"), managerEmail)


        val networkService = networkService.postWithusApply(user_idx,startUp_idx,job_idx,detailJob,recrutNum,salary,city_idx,mainTask,intro,companyName,managerName,managerPhone,managerEmail,img)

        networkService.enqueue(object : Callback<PostLoginResponse> {
            override fun onFailure(call: Call<PostLoginResponse>, t: Throwable) {
                Log.e("서버 접속 오류", "Error ", t)
            }

            override fun onResponse(call: Call<PostLoginResponse>, response: Response<PostLoginResponse>) {
                if (response.isSuccessful) {
                    response?.takeIf { it.isSuccessful }
                            ?.body()
                            ?.let {
                                if (it.success == true) {
                                    // 공고 작성 완료 메시지 보내기
                                    var intent = Intent()
                                    intent.putExtra("writeSuccess", 100)
                                    setResult(RESULT_OK, intent)

                                    Toast.makeText(applicationContext, "공고 작성이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                                    finish()
                                }
                            }
                }else{

                }
            }
        })

    }


    /** 사진 첨부파일 위한 함수1 */
    fun requestReadExternalStoragePermission() {

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
        ) {
            if (shouldShowRequestPermissionRationale(android.Manifest.permission.READ_EXTERNAL_STORAGE
                    )
            ) {
            } else { requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
                    My_READ_STORAGE_REQUEST_CODE
            )
            }
        } else {
            showAlbum()
        }
    }

    /** 사진 첨부파일 위한 함수2 */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == My_READ_STORAGE_REQUEST_CODE) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showAlbum()
            } else {
            }
        }
    }

    /** 사진 첨부파일 위한 함수3 */
    fun showAlbum() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = android.provider.MediaStore.Images.Media.CONTENT_TYPE
        intent.data = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        startActivityForResult(intent, REQ_CODE_SELECT_IMAGE)

    }

    /** 사진 첨부파일 위한 함수4 */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_CODE_SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {

                    selectedImageUri = data.data!!
                    //Uri를 getRealPathFromURI라는 메소드를 통해 절대 경로를 알아내고, 인스턴스 변수 imageURI에 넣어줍니다!

                    Glide.with(this@WriteActivity)
                            .load(selectedImageUri)
                            .thumbnail(0.1f)
                            .into(iv_thumbnail)

                    val options = BitmapFactory.Options()

                    var input: InputStream? = null // here, you need to get your context.
                    try {
                        input = this!!.contentResolver.openInputStream(selectedImageUri)
                    } catch (e: FileNotFoundException) {
                        e.printStackTrace()
                    }

                    val bitmap = BitmapFactory.decodeStream(input, null, options) // InputStream 으로부터 Bitmap 을 만들어 준다.
                    val baos = ByteArrayOutputStream()
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos)

                    val photoBody = RequestBody.create(MediaType.parse("image/jpg"), baos.toByteArray())
                    val photo = File(selectedImageUri.toString()) // 가져온 파일의 이름을 알아내려고 사용합니다

                    img = MultipartBody.Part.createFormData("img", photo.name, photoBody)

                }
            }
        }

        // 근무지역 필터 뷰에서 필터 값 받기
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 3000) {
                city_idx = data?.getIntExtra("city_idx", -1)!!
                if (city_idx == -1) {
                    startup = startUp_idx
                } else {
                    city = city_idx
                }
                // 선택한 필터로 근무지역 텍스트 바꾸기
                when (city) {
                    1 -> tvCity.text = "강남구"
                    2 -> tvCity.text = "강동구"
                    3 -> tvCity.text = "강북구"
                    4 -> tvCity.text = "강서구"
                    5 -> tvCity.text = "관악구"
                    6 -> tvCity.text = "광진구"
                    7 -> tvCity.text = "구로구"
                    8 -> tvCity.text = "금천구"
                    9 -> tvCity.text = "노원구"
                    10 -> tvCity.text = "도봉구"
                    11 -> tvCity.text = "동대문구"
                    12 -> tvCity.text = "동작구"
                    13 -> tvCity.text = "마포구"
                    14 -> tvCity.text = "서대문구"
                    15 -> tvCity.text = "서초구"
                    16 -> tvCity.text = "성동구"
                    17 -> tvCity.text = "성북구"
                    18 -> tvCity.text = "송파구"
                    19 -> tvCity.text = "양천구"
                    20 -> tvCity.text = "영등포구"
                    21 -> tvCity.text = "용산구"
                    22 -> tvCity.text = "은평구"
                    23 -> tvCity.text = "종로구"
                    24 -> tvCity.text = "중구"
                    25 -> tvCity.text = "중랑구"
                }
            }
        }

        // 스타트업 분야 필터 뷰에서 필터 값 받기
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 3000) {
                startUp_idx = data?.getIntExtra("startup_idx", -1)!!
                if (startUp_idx == -1) {
                    city = city_idx
                } else {
                    startup = startUp_idx
                }
                // 선택한 필터로 스타트업 분야 텍스트 바꾸기
                when (startup) {
                    1 -> tvStartup.text = "IT"
                    2 -> tvStartup.text = "여행"
                    3 -> tvStartup.text = "교육"
                    4 -> tvStartup.text = "금융"
                    5 -> tvStartup.text = "보안"
                    6 -> tvStartup.text = "교통"
                    7 -> tvStartup.text = "건설"
                    8 -> tvStartup.text = "게임"
                    9 -> tvStartup.text = "부동산"
                    10 -> tvStartup.text = "친환경"
                    11 -> tvStartup.text = "헬스케어"
                    12 -> tvStartup.text = "사회봉사"
                    13 -> tvStartup.text = "자연과학"
                    14 -> tvStartup.text = "전자제품"
                    15 -> tvStartup.text = "물류/유통"
                    16 -> tvStartup.text = "광고/마케팅"
                    17 -> tvStartup.text = "농/축/수산업"
                    18 -> tvStartup.text = "엔터테인먼트"
                    19 -> tvStartup.text = "바이오/의료"
                    20 -> tvStartup.text = "기타"
                }
            }
        }


    }
}
