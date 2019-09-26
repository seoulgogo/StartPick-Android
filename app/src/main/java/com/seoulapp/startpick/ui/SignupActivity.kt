package com.seoulapp.startpick.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.seoulapp.startpick.R
import com.isapanah.awesomespinner.AwesomeSpinner
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_signup.*
import android.widget.Toast
import com.bumptech.glide.Glide
import com.seoulapp.startpick.ui.mypage.MypageFragment
import kotlinx.android.synthetic.main.fragment_mypage.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.jetbrains.anko.activityManager
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream


class SignupActivity : AppCompatActivity() {

    var et_email: Boolean = false
    var et_pw: Boolean = false
    var et_name: Boolean = false
    var et_phone: Boolean = false
    var et_birth: Boolean = false
    var btn_sex: Boolean = false
    var select_duty: Boolean = false
    var next_btn_activation: Boolean = false

    val My_READ_STORAGE_REQUEST_CODE = 88
    private val REQ_CODE_SELECT_IMAGE = 100
    lateinit var selectedImageUri : Uri


    private var imgs : MultipartBody.Part? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        setOnClickListener()
        spinner()
        editText()
    }

    private fun editText() {
        //이메일
        et_email_signup_act.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val text = et_email_signup_act.text
                //e-mail form
                val email_form = "^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$"

                //email폼에 맞게 썼는지
                if (text.matches(Regex(email_form))) {
                    et_email = true
                } else {
                    et_email = false
                }

                if (et_email) {
                    if (et_birth) {
                        if (et_name) {
                            if (et_phone) {
                                if (et_pw) {
                                    if (btn_sex) {
                                        if (select_duty) {
                                            next_btn_activation = true
                                            rl_btn_intent_signup_act.setBackgroundResource(R.color.maincolor)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        })

        //비밀번호
        et_password_signup_act.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val text = et_password_signup_act.text.toString()
                val pw_form = "((?=.*\\d)(?=.*[a-zA-Z]).{6,20})"

                if (text.length >= 8 && text.matches(Regex(pw_form))) {
                    et_pw = true
                } else {
                    et_pw = false
                }

                if (et_pw) {
                    if (et_birth) {
                        if (et_name) {
                            if (et_phone) {
                                if (et_email) {
                                    if (btn_sex) {
                                        if (select_duty) {
                                            next_btn_activation = true
                                            rl_btn_intent_signup_act.setBackgroundResource(R.color.maincolor)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }


            }
        })

        //이름
        et_name_signup_act.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val text = et_name_signup_act.text

                if (text.length > 0) {
                    et_name = true
                } else {
                    et_name = false
                }

                if (et_name) {
                    if (et_birth) {
                        if (et_email) {
                            if (et_phone) {
                                if (et_pw) {
                                    if (btn_sex) {
                                        if (select_duty) {
                                            next_btn_activation = true
                                            rl_btn_intent_signup_act.setBackgroundResource(R.color.maincolor)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        })

        //휴대번호
        et_phone_signup_act.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val text = et_phone_signup_act.text

                if (text.length > 0) {
                    et_phone = true
                } else {
                    et_phone = false
                }

                if (et_phone) {
                    if (et_birth) {
                        if (et_name) {
                            if (et_email) {
                                if (et_pw) {
                                    if (btn_sex) {
                                        if (select_duty) {
                                            next_btn_activation = true
                                            rl_btn_intent_signup_act.setBackgroundResource(R.color.maincolor)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

        })

        //생년월일
        et_birth_signup_act.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val text = et_birth_signup_act.text

                val birth_form = "^\\s*(\\d{4})(-|\\)|\\s)*(\\d{2})(-|\\s)*(\\d{2})\\s*$"

                //email폼에 맞게 썼는지
                if (text.matches(Regex(birth_form))) {
                    et_birth = true
                } else {
                    et_birth = false
                }

                if (et_birth) {
                    if (et_email) {
                        if (et_name) {
                            if (et_phone) {
                                if (et_pw) {
                                    if (btn_sex) {
                                        if (select_duty) {
                                            //## 회원가입 완료 활성화..!!
                                            next_btn_activation = true
                                            rl_btn_intent_signup_act.setBackgroundResource(R.color.maincolor)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }

        })

        //라디오 버튼
        var rb_sex = rg_sex_signup_act.checkedRadioButtonId.toString()

        if (rb_sex.length > 0)
            btn_sex = true
        else
            btn_sex = false

    }


    fun spinner() {

        var spinner = findViewById(R.id.awesomeSpinner_spinner2) as AwesomeSpinner

        var spinnerArray = ArrayList<String>()
        spinnerArray.add("기획자")
        spinnerArray.add("개발자")
        spinnerArray.add("디자이너")
        spinnerArray.add("건축학자")

        val categoriesAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray)

        spinner.setAdapter(categoriesAdapter)

        /*     spinner.setOnSpinnerItemClickListener(AwesomeSpinner.onSpinnerItemClickListener<String> { position, itemAtPosition ->
                 spinner.setSpinnerHint("alsdkfj")
             })
     */
        spinner.setOnSpinnerItemClickListener(
                AwesomeSpinner.onSpinnerItemClickListener { position, itemAtPosition ->
                    select_duty = true

                    if (select_duty) {
                        if (et_birth) {
                            if (et_name) {
                                if (et_email) {
                                    if (et_pw) {
                                        if (btn_sex) {
                                            if (et_phone) {
                                                next_btn_activation = true
                                                rl_btn_intent_signup_act.setBackgroundResource(R.color.maincolor)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                })

    }

    fun setOnClickListener() {
        btn_back_signup_act.setOnClickListener {
            finish()
        }

        ll_signup_act.setOnClickListener {
            keyboardDown(ll_signup_act)
        }

        rl_profile_signup_act.setOnClickListener {
            requestReadExternalStoragePermission()
        }


        rl_btn_intent_signup_act.setOnClickListener {

            var text = ""

            if (next_btn_activation) {

                //## 통신해야함

                finish()
                startActivity<SignMainActivity>()
            } else {

                if (!et_email)
                    text = "이메일"
                else if (!et_pw)
                    text = "비밀번호"
                else if (!et_name)
                    text = "이름"
                else if (!et_phone)
                    text = "휴대폰번호"
                else if (!et_birth)
                    text = "생년월일"
                else if (!btn_sex)
                    text = "성별"
                else if (!select_duty)
                    text = "직무"

                Toast.makeText(getApplicationContext(), text + "의 입력이 잘못 되었습니다.", Toast.LENGTH_LONG).show()

            }
        }
    }

    private fun keyboardDown(view: View) {

        val imm: InputMethodManager = applicationContext!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    //저장소 권한 확인
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

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == My_READ_STORAGE_REQUEST_CODE) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showAlbum()
            } else {
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

                    Glide.with(this@SignupActivity)
                            .load(selectedImageUri)
                            .thumbnail(0.1f)
                            .into(img_profile_mypage_fg)

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

                    imgs = MultipartBody.Part.createFormData("imgs", photo.name, photoBody)

                }
            }
        }
    }

}

