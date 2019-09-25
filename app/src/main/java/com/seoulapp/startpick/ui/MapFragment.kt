package com.seoulapp.startpick.ui

import android.Manifest
import android.annotation.SuppressLint
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.seoulapp.startpick.R
import com.seoulapp.startpick.data.InfoMapfragData
import com.seoulapp.startpick.ui.adapter.InfoMapAdapter
import kotlinx.android.synthetic.main.fragment_map.*
import org.jetbrains.anko.support.v4.ctx
import java.util.*
import kotlin.collections.ArrayList
import android.content.Context.LOCATION_SERVICE
import android.support.v4.app.ActivityCompat
import android.support.design.widget.Snackbar
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat


class MapFragment : Fragment() {

    private lateinit var rootView: View

    val My_LOCATION_REQUEST_CODE = 88

    lateinit var mapAdapter: InfoMapAdapter
    var mylocation: Location? = null
    var address: String? = null

    private val PERMISSIONS_REQUEST_CODE = 100
    var needRequest = false

    //var REQUIRED_PERMISSIONS = Array<String>(2) {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}

    //지도버튼 --> 배열로 집어 넣어버리는 건 어떻게 생각하시져?
    var btn_gangseo = 0
    var btn_yangcheon = 0
    var btn_guro = 0
    var btn_yeongdeungpo= 0
    var btn_geumcheon = 0
    var btn_dongjak = 0
    var btn_gwanak = 0
    var btn_seocho = 0
    var btn_gangnam = 0
    var btn_songpa = 0
    var btn_gangdong = 0
    var btn_mapo = 0
    var btn_seodamun = 0
    var btn_eunpyeong = 0
    var btn_jongno = 0
    var btn_yongsan = 0
    var btn_junggu = 0
    var btn_seongdong = 0
    var btn_seongbuk = 0
    var btn_gangbuk = 0
    var btn_dongdaemun = 0
    var btn_gwangjin = 0
    var btn_jungnang = 0
    var btn_nowon = 0
    var btn_dobon = 0

    var MapBtnArray : ArrayList<Int> = arrayListOf(btn_gangseo, btn_yangcheon, btn_guro, btn_yeongdeungpo,btn_geumcheon
            ,btn_dongjak,btn_gwanak,btn_seocho,btn_gangnam, btn_songpa, btn_gangdong,btn_mapo, btn_seodamun,btn_eunpyeong,
            btn_jongno, btn_yongsan,btn_junggu, btn_seongdong,btn_seongbuk, btn_gangbuk, btn_dongdaemun, btn_gwangjin,
            btn_jungnang,btn_nowon,btn_dobon)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_map, container, false)

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setRecyclerView()
        //spinner()

        mapsetOnClick()
        setOnClickListener()
    }


    fun setOnClickListener() {

        tv_address_dnleh_map_fragment.setOnClickListener {

            //GetUserLocation()
            requestReadUserLocationPermission()
        }
    }

    fun mapsetOnClick(){

        btn_map_page_spot_gangseo.setOnClickListener {
            mapFlag(btn_map_page_spot_gangseo, btn_gangseo)
            //나머지 버튼들은 비활성화..! --> 배열로 집어 넣었으니 그거 생각해서 해보면 될듯
        }




    }

    private fun mapFlag(id : View, btn_flag : Int) {

        var flag = btn_flag

        if(flag==1)
        {
            flag = 0
            id.isSelected = false
        }
        else{
            flag = 1
            id.isSelected = true
        }

        //나머지 btn_flag는 모두 비활성화 되도록 해야함....

    }

    //위치 권한 확인
    private fun requestReadUserLocationPermission() {

        if (ContextCompat.checkSelfPermission(ctx, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ) {
            if (shouldShowRequestPermissionRationale(android.Manifest.permission.ACCESS_FINE_LOCATION)
            ) {
            } else { requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                    My_LOCATION_REQUEST_CODE
            )
            }
        } else {
            GetUserLocation()
        }
    }
/*
    fun onMapReady() {

        // 런타임 퍼미션 처리
        // 위치 퍼미션을 가지고 있는지 체크
        val hasFineLocationPermission = ContextCompat.checkSelfPermission(context!!,
                Manifest.permission.ACCESS_FINE_LOCATION)
        val hasCoarseLocationPermission = ContextCompat.checkSelfPermission(context!!,
                Manifest.permission.ACCESS_COARSE_LOCATION)

        // 퍼미션 요청을 허용한 적이 없다면 퍼미션 요청이 필요
        if (hasFineLocationPermission != PackageManager.PERMISSION_GRANTED || hasCoarseLocationPermission != PackageManager.PERMISSION_GRANTED) {
            // 사용자가 퍼미션 거부를 한 적이 있는 경우
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity!!, Manifest.permission.ACCESS_FINE_LOCATION)) {

                // 요청을 진행하기 전에 사용자가에게 퍼미션이 필요한 이유 설명
                Snackbar.make(rootView, "이 앱을 실행하려면 위치 접근 권한이 필요합니다.",
                        Snackbar.LENGTH_INDEFINITE).setAction("확인") {
                    // 사용자게에 퍼미션 요청
                    ActivityCompat.requestPermissions(activity!!, REQUIRED_PERMISSIONS,
                            PERMISSIONS_REQUEST_CODE)
                }.show()

            } else {
                // 사용자가 퍼미션 거부를 한 적이 없는 경우
                ActivityCompat.requestPermissions(activity!!, REQUIRED_PERMISSIONS,
                        PERMISSIONS_REQUEST_CODE)
            }
        }
    }*/

    @SuppressLint("MissingPermission")
    fun GetUserLocation() {

        var locationManager: LocationManager = activity!!.getSystemService(LOCATION_SERVICE) as LocationManager

        mylocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)

        // getting GPS status
        var checkGPS = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

        // getting network status
        var checkNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

        //##퍼미션 허용하는 함수를 하나 만들어야함!!!


        //gps를 가져올 수 있는 상태인지, network가 연결되어 있는지 판별
        if (!checkGPS && !checkNetwork) {
            Toast.makeText(ctx, "No Service Provider Available", Toast.LENGTH_SHORT).show()
        } else {
            val locationListener = object : LocationListener {
                override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
                override fun onProviderEnabled(provider: String?) {}
                override fun onProviderDisabled(provider: String?) {}
                override fun onLocationChanged(location: Location?) {
                    this@MapFragment.mylocation = location
                    makeAddress()
                }
            }

            val networkLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            if (networkLocation != null) {
                mylocation = networkLocation
                makeAddress()
            }

            val gpsLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            if (gpsLocation != null) {
                mylocation = gpsLocation
                makeAddress()
            }

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1f, locationListener)
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 1f, locationListener)

            //locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0.1f, mylocation)
        }
    }

    /**
     * 주소값 가져오기
     */
    private fun makeAddress() {
        val geocoder = Geocoder(context, Locale.getDefault())

        try {
            address = geocoder.getFromLocation(
                    mylocation?.latitude ?: (-1).toDouble(),
                    mylocation?.longitude ?: (-1).toDouble(),
                    1
            )[0].getAddressLine(0)
            Toast.makeText(context, "위도는!"+mylocation?.latitude.toString() + "경도는!" + mylocation?.longitude.toString(), Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    /*fun spinner() {

        var spinner_location: AwesomeSpinner = R.id.spinner_mylocation_map_fragment as AwesomeSpinner
        var spinner_thema: AwesomeSpinner = R.id.spinner_thema_map_fragment as AwesomeSpinner

        var spinnerlocationArray = ArrayList<String>()
        spinnerlocationArray.add("강남구")
        spinnerlocationArray.add("노원구")
        spinnerlocationArray.add("성북구")
        spinnerlocationArray.add("서초구")
        spinnerlocationArray.add("은평구")

        var spinnerthemaArray = ArrayList<String>()
        spinnerthemaArray.add("시창업센터")
        spinnerthemaArray.add("이건 모시여?")
        spinnerthemaArray.add("글쎄")
        spinnerthemaArray.add("이거 알려주세여")
        spinnerthemaArray.add("뭐죠?")

        val categoriesAdapter = ArrayAdapter<String>(ctx, android.R.layout.simple_spinner_item, spinnerlocationArray)
        val categoriesAdapter2 = ArrayAdapter<String>(ctx, android.R.layout.simple_spinner_item, spinnerthemaArray)


        spinner_location.setAdapter(categoriesAdapter)
        spinner_thema.setAdapter(categoriesAdapter2)


        *//*     spinner.setOnSpinnerItemClickListener(AwesomeSpinner.onSpinnerItemClickListener<String> { position, itemAtPosition ->
                 spinner.setSpinnerHint("alsdkfj")
             })
     *//*
        spinner_location.setOnSpinnerItemClickListener(
                AwesomeSpinner.onSpinnerItemClickListener { position, itemAtPosition ->
                    //선택되었을때 행해지는 것
                })
    }*/

    fun setRecyclerView() {
        var mapInfoData: ArrayList<InfoMapfragData> = ArrayList()

        mapInfoData.add(InfoMapfragData("DMC 창업센터", "시창업센터", "서울시 노원구 공릉동 맞춰ㅏ라!", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD", "02-31628-1111", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD"))
        mapInfoData.add(InfoMapfragData("DMC 창업센터", "시창업센터", "서울시 노원구 공릉동 맞춰ㅏ라!", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD", "02-31628-1111", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD"))
        mapInfoData.add(InfoMapfragData("DMC 창업센터", "시창업센터", "서울시 노원구 공릉동 맞춰ㅏ라!", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD", "02-31628-1111", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD"))
        mapInfoData.add(InfoMapfragData("DMC 창업센터", "시창업센터", "서울시 노원구 공릉동 맞춰ㅏ라!", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD", "02-31628-1111", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD"))
        mapInfoData.add(InfoMapfragData("DMC 창업센터", "시창업센터", "서울시 노원구 공릉동 맞춰ㅏ라!", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD", "02-31628-1111", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD"))
        mapInfoData.add(InfoMapfragData("DMC 창업센터", "시창업센터", "서울시 노원구 공릉동 맞춰ㅏ라!", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD", "02-31628-1111", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD"))
        mapInfoData.add(InfoMapfragData("DMC 창업센터", "시창업센터", "서울시 노원구 공릉동 맞춰ㅏ라!", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD", "02-31628-1111", "http://cfile210.uf.daum.net/image/99E847425AFAF95F2B35AD"))

        mapAdapter = InfoMapAdapter(activity!!, mapInfoData)
        //맞춤형
        rv_seoul_startup_info_map_frag.adapter = mapAdapter
        rv_seoul_startup_info_map_frag.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

    }
}
