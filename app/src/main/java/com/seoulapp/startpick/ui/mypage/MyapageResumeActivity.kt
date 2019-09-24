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
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.bumptech.glide.Glide
import com.seoulapp.startpick.R
import kotlinx.android.synthetic.main.activity_myapage_resume.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
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



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myapage_resume)

        setOnClickListener()
        editText()
    }

    fun setOnClickListener() {
        btn_back_mypage_resume_act.setOnClickListener {
            finish()
        }

        rl_profile_mypage_resume_act.setOnClickListener {
            requestReadExternalStoragePermission()
        }

        btn_store_mypage_resume_act.setOnClickListener {
            if(next_btn_activation)
            {
                //##통신
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
                et_link_mypage_resume_act.visibility = View.GONE
            }
            else{
                btn_link_arrow = true
                btn_link_mypage_resume_act.isSelected = true
                et_link_mypage_resume_act.visibility = View.VISIBLE
            }
        }

    }

    private fun test(id : View, btn_flag : Boolean, view : View ) {

            if(btn_flag)
            {
                //btn_flag = false
                id.isSelected = false
                view.visibility = View.GONE
            }
            else{
                //btn_flag = true
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
                val text = et_phone_mypage_resume_act.text

                if (text.length > 0) {
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
                val text = et_resume_theme_mypage_resume_act.text

                if (text.length > 0) {
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
