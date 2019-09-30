package com.seoulapp.startpick.ui.mypage

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seoulapp.startpick.R
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.seoulapp.startpick.data.UserInfoData
import com.seoulapp.startpick.db.SharedPreferenceController
import com.seoulapp.startpick.network.ApplicationController
import com.seoulapp.startpick.network.NetworkService
import com.seoulapp.startpick.network.get.GetMypageUserInfoResponse
import com.seoulapp.startpick.network.post.PostSignupResponse
import com.seoulapp.startpick.ui.adapter.MypagenaviAdapter
import kotlinx.android.synthetic.main.fragment_mypage.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.startActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.InputStream


class MypageFragment : Fragment() {

    private lateinit var rootView: View

    val My_READ_STORAGE_REQUEST_CODE = 88
    private val REQ_CODE_SELECT_IMAGE = 100
    lateinit var selectedImageUri: Uri

    private var img: MultipartBody.Part? = null

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //userInfo통신
        UserInfo()
        configureMainTab()
        setOnClickListener()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_mypage, container, false)

        return rootView
    }

    private fun UserInfo() {
        //이걸로 바꿔줘야함!!!
        if (SharedPreferenceController.MY_EMAIL.length > 0)
            getMypageUserInfoResponse(SharedPreferenceController.MY_EMAIL)

        //getMypageUserInfoResponse("soso3786@gmail.com")
    }

    //이미지변경
    fun postImgChangeResponse(img : MultipartBody.Part?) {

        var email = RequestBody.create(MediaType.parse("text/plain"), SharedPreferenceController.MY_EMAIL)

        val networkService = networkService.postImgChange(email,img)

        Log.d("TAGG", "BBBB")

        networkService.enqueue(object : Callback<PostSignupResponse> {
            override fun onFailure(call: Call<PostSignupResponse>, t: Throwable) {
                Log.e("이미지 변경 error", "Error ", t)
            }

            override fun onResponse(call: Call<PostSignupResponse>, response: Response<PostSignupResponse>) {
                Log.e("onResponse", response.message().toString())
                if (response.isSuccessful) {
                    response?.takeIf { it.isSuccessful }
                            ?.body()
                            ?.let {
                                if (it.success == true) {
                                    Log.e("이미지 변경 success", response.message().toString())
                                }
                            }
                }else{
                    Log.e("통신 good,,이미지 변경 실패", response.message().toString())
                }
            }
        })
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

    private fun makeView(data : UserInfoData)
    {
        //이미지
        //user_porfile
        if (data.img == null)
            Glide.with(ctx).load(R.drawable.icon_profile).into(img_profile_mypage_fg)
        else
            Glide.with(ctx).load(data.img).into(img_profile_mypage_fg)

        //이름
        tv_username_mypage_frag.setText(data.name)
        //이메일
        tv_email_mypage_frag.setText(data.email)
        //직업
        tv_major_mypage_frag.setText(data.job)

        var gender_string = ""
        //나이, 성별
        if(data.gender == 0)
            gender_string = "남"
        else
            gender_string = "여"

        tv_age_gender_mypage_frag.setText("("+gender_string+","+ data.age + ")")
    }

    //ViewPager
    private fun configureMainTab() {

        vp_noswipe_mypage_fragment.adapter = MypagenaviAdapter(childFragmentManager!!, 3)
        vp_noswipe_mypage_fragment.offscreenPageLimit = 2


        tl_mypage_fragment.setupWithViewPager(vp_noswipe_mypage_fragment)

        val topTabLayout: View = activity!!.layoutInflater.inflate(R.layout.tablayout_navi_mypage_fragment, null, false)
        tl_mypage_fragment.getTabAt(0)!!.customView =
                topTabLayout.findViewById(R.id.rl_scrap_mypage_frag) as RelativeLayout
        tl_mypage_fragment.getTabAt(1)!!.customView =
                topTabLayout.findViewById(R.id.rl_resume_mypage_navi_frag) as RelativeLayout
        tl_mypage_fragment.getTabAt(2)!!.customView =
                topTabLayout.findViewById(R.id.rl_supportstatus_mypage_navi_frag) as RelativeLayout

    }

    private fun setOnClickListener() {
        rl_profile_mypage_fg.setOnClickListener {
            requestReadExternalStoragePermission()
        }

        img_my_uploadnotice_mypage_frg.setOnClickListener {
            startActivity<MyPostedNoticeActivity>()
        }


    }

    //저장소 권한 확인
    fun requestReadExternalStoragePermission() {

        if (ContextCompat.checkSelfPermission(ctx, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
        ) {
            if (shouldShowRequestPermissionRationale(android.Manifest.permission.READ_EXTERNAL_STORAGE
                    )
            ) {
            } else {
                requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),
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

                    Glide.with(this@MypageFragment)
                            .load(selectedImageUri)
                            .thumbnail(0.1f)
                            .into(img_profile_mypage_fg)

                    val options = BitmapFactory.Options()

                    var input: InputStream? = null // here, you need to get your context.
                    try {
                        input = activity!!.contentResolver.openInputStream(selectedImageUri)
                    } catch (e: FileNotFoundException) {
                        e.printStackTrace()
                    }

                    val bitmap = BitmapFactory.decodeStream(input, null, options) // InputStream 으로부터 Bitmap 을 만들어 준다.
                    val baos = ByteArrayOutputStream()
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 20, baos)

                    val photoBody = RequestBody.create(MediaType.parse("image/jpg"), baos.toByteArray())
                    val photo = File(selectedImageUri.toString()) // 가져온 파일의 이름을 알아내려고 사용합니다

                    img = MultipartBody.Part.createFormData("img", photo.name, photoBody)

                    postImgChangeResponse(img)

                }
            }
        }
    }

}
