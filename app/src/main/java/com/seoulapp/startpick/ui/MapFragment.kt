package com.seoulapp.startpick.ui

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
import com.seoulapp.startpick.ui.adapter.InfoMapAdapter
import kotlinx.android.synthetic.main.fragment_map.*
import org.jetbrains.anko.support.v4.ctx
import java.util.*
import kotlin.collections.ArrayList
import android.content.Context.LOCATION_SERVICE
import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.ArrayAdapter
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.isapanah.awesomespinner.AwesomeSpinner
import com.seoulapp.startpick.data.MapGetData
import com.seoulapp.startpick.network.ApplicationController
import com.seoulapp.startpick.network.NetworkService
import com.seoulapp.startpick.network.get.GetMapPlaceAllResponse
import kotlinx.android.synthetic.main.fragment_map.view.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MapFragment : Fragment() {

    private lateinit var rootView: View

    val My_LOCATION_REQUEST_CODE = 88

    lateinit var mapAdapter: InfoMapAdapter
    var mylocation: Location? = null
    var address: String? = null

    var latitude: Double = 1.11
    var longitude: Double = 1.11

    lateinit var id: ArrayList<View>

    private val PERMISSIONS_REQUEST_CODE = 100
    var needRequest = false

    val networkService: NetworkService by lazy {
        ApplicationController.instance.networkService
    }

    //지도버튼 --> 배열로 집어 넣어버리는 건 어떻게 생각하시져?
    var btn_gangseo = 0
    var btn_yangcheon = 0
    var btn_guro = 0
    var btn_yeongdeungpo = 0
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


    var MapBtnArray: ArrayList<Int> = arrayListOf(btn_gangnam, btn_gangdong, btn_gangbuk, btn_gangseo, btn_gwanak
            , btn_gwangjin, btn_guro, btn_geumcheon, btn_nowon, btn_dobon, btn_dongdaemun, btn_dongjak, btn_mapo,
            btn_seodamun, btn_seocho, btn_seongdong, btn_seongbuk, btn_songpa, btn_yangcheon, btn_yeongdeungpo, btn_yongsan,
            btn_eunpyeong, btn_jongno, btn_junggu, btn_jungnang)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_map, container, false)

        id = arrayListOf(rootView.btn_map_page_spot_gangnam, rootView.btn_map_page_spot_gangdong, rootView.btn_map_page_spot_gangbug, rootView.btn_map_page_spot_gangseo, rootView.btn_map_page_spot_gwanak,
                rootView.btn_map_page_spot_gwangjin, rootView.btn_map_page_spot_guro, rootView.btn_map_page_spot_geumcheon,
                rootView.btn_map_page_spot_nowon, rootView.btn_map_page_spot_dobong, rootView.btn_map_page_spot_dongdaemun,
                rootView.btn_map_page_spot_dongjak, rootView.btn_map_page_spot_mapo, rootView.btn_map_page_spot_seodaemun,
                rootView.btn_map_page_spot_seocho, rootView.btn_map_page_spot_seongdong, rootView.btn_map_page_spot_seongbug,
                rootView.btn_map_page_spot_songpa, rootView.btn_map_page_spot_yangcheon, rootView.btn_map_page_spot_yeongdeungpo,
                rootView.btn_map_page_spot_yongsan, rootView.btn_map_page_spot_eunpyeong, rootView.btn_map_page_spot_jongro,
                rootView.btn_map_page_spot_junggu, rootView.btn_map_page_spot_junglang)

        //처음 정보들 통신
        getMapFragmentResponse()

        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setOnClickListener()

    }

    fun setOnClickListener() {

        rl_mylocation_map_fragment.setOnClickListener {

            Toast.makeText(ctx, "내 위치 정보를 찾고 있습니다.", Toast.LENGTH_SHORT).show()
            requestReadUserLocationPermission()
            var dataList: ArrayList<MapGetData> = ArrayList()
            mapAdapter.dataList.clear()
            postMylocationResponse()
        }

        tv_all_see_map_frag.setOnClickListener {
            Toast.makeText(ctx, "전지역을 찾고 있고 있습니다.", Toast.LENGTH_SHORT).show()
            getMapFragmentResponse()
        }

        //강남
        btn_map_page_spot_gangnam.setOnClickListener {
            mapSelectorArray(0)
        }

        //강동
        btn_map_page_spot_gangdong.setOnClickListener {
            mapSelectorArray(1)
        }

        //강북
        btn_map_page_spot_gangbug.setOnClickListener {
            mapSelectorArray(2)
        }
        //강서
        btn_map_page_spot_gangseo.setOnClickListener {
            mapSelectorArray(3)
        }

        //관악
        btn_map_page_spot_gwanak.setOnClickListener {
            mapSelectorArray(4)
        }
        //광진
        btn_map_page_spot_gwangjin.setOnClickListener {
            mapSelectorArray(5)
        }
        //구로
        btn_map_page_spot_guro.setOnClickListener {
            mapSelectorArray(6)
        }
        //금천
        btn_map_page_spot_geumcheon.setOnClickListener {
            mapSelectorArray(7)
        }
        //노원
        btn_map_page_spot_nowon.setOnClickListener {
            mapSelectorArray(8)
        }
        //도봉
        btn_map_page_spot_dobong.setOnClickListener {
            mapSelectorArray(9)
        }
        //동대문
        btn_map_page_spot_dongdaemun.setOnClickListener {
            mapSelectorArray(10)
        }
        //동작
        btn_map_page_spot_dongjak.setOnClickListener {
            mapSelectorArray(11)
        }
        //마포
        btn_map_page_spot_mapo.setOnClickListener {
            mapSelectorArray(12)
        }
        //서대문
        btn_map_page_spot_seodaemun.setOnClickListener {
            mapSelectorArray(13)
        }
        //서초
        btn_map_page_spot_seocho.setOnClickListener {
            mapSelectorArray(14)
        }
        //성동
        btn_map_page_spot_seongdong.setOnClickListener {
            mapSelectorArray(15)
        }
        //성북
        btn_map_page_spot_seongbug.setOnClickListener {
            mapSelectorArray(16)
        }
        //송파
        btn_map_page_spot_songpa.setOnClickListener {
            mapSelectorArray(17)
        }
        //양천
        btn_map_page_spot_yangcheon.setOnClickListener {
            mapSelectorArray(18)
        }
        //영등포
        btn_map_page_spot_yeongdeungpo.setOnClickListener {
            mapSelectorArray(19)
        }
        //용산
        btn_map_page_spot_yongsan.setOnClickListener {
            mapSelectorArray(20)
        }
        //은평
        btn_map_page_spot_eunpyeong.setOnClickListener {
            mapSelectorArray(21)
        }
        //종로
        btn_map_page_spot_jongro.setOnClickListener {
            mapSelectorArray(22)
        }
        //중구
        btn_map_page_spot_junggu.setOnClickListener {
            mapSelectorArray(23)
        }
        //중랑
        btn_map_page_spot_junglang.setOnClickListener {
            mapSelectorArray(24)
        }
    }


    fun mapSelectorArray(index: Int) {

        if (MapBtnArray[index] == 0) {
            var i = 0
            for (i in 0..MapBtnArray.size - 1) {
                //모두 비활성화 시키기
                MapBtnArray[i] = 0
                id[i].isSelected = false
            }
            MapBtnArray[index] = 1
            id[index].isSelected = true
            //리스트가 지워지지 않는다면, 여기서 원래 있던 아이템들을 싹 다 지워주는 작업을 해야함.
            //활성화가 되었을때 통신,,,!
            getMapCityFragmentResponse(index + 1)

        } else {
            MapBtnArray[index] = 0
            id[index]?.isSelected = false
            getMapFragmentResponse()
        }
    }

    //처음 map fragmnet에 들어왔을때,
    private fun getMapFragmentResponse() {

        val getMapInfoResponse: Call<GetMapPlaceAllResponse> = networkService.getMapPlaceAll()

        getMapInfoResponse.enqueue(object : Callback<GetMapPlaceAllResponse> {

            override fun onFailure(call: Call<GetMapPlaceAllResponse>, t: Throwable) {
                Log.e("지도 all list fail", t.toString())
            }

            override fun onResponse(call: Call<GetMapPlaceAllResponse>, response: Response<GetMapPlaceAllResponse>
            ) {

                val temp: ArrayList<MapGetData> = response.body()!!.data
                val status = response.body()!!.status

                if (temp.size > 0) {
                    if (status == 200) {

                        var dataList: ArrayList<MapGetData> = temp

                        mapAdapter = InfoMapAdapter(activity!!, dataList)
                        rv_seoul_startup_info_map_frag.adapter = mapAdapter
                        rv_seoul_startup_info_map_frag.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

                    }
                }

                Log.v("TAGG : size1 ", temp.size.toString())

            }
        })
    }

    //city를 지정해주었을때,
    private fun getMapCityFragmentResponse(cityIdx: Int) {

        val getMapInfoResponse: Call<GetMapPlaceAllResponse> = networkService.getPlaceCity(cityIdx)

        getMapInfoResponse.enqueue(object : Callback<GetMapPlaceAllResponse> {

            override fun onFailure(call: Call<GetMapPlaceAllResponse>, t: Throwable) {
                Log.e("지도 city list fail", t.toString())
            }

            override fun onResponse(call: Call<GetMapPlaceAllResponse>, response: Response<GetMapPlaceAllResponse>
            ) {
                Log.e("지도 city list success", response.body().toString())
                val temp: ArrayList<MapGetData> = response.body()!!.data
                val status = response.body()!!.status

                if (status == 200) {
                    if (temp.size > 0) {
                        var dataList: ArrayList<MapGetData> = temp

                        mapAdapter = InfoMapAdapter(activity!!, dataList)
                        rv_seoul_startup_info_map_frag.adapter = mapAdapter
                        rv_seoul_startup_info_map_frag.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

                        /*val position = mapAdapter.itemCount
                        //mapAdapter.dataList.addAll(temp)
                        mapAdapter.notifyDataSetChanged()*/

                    } else {

                    }
                } else if (status == 400) {
                    mapAdapter.dataList.clear()
                    rv_seoul_startup_info_map_frag.adapter = mapAdapter
                    rv_seoul_startup_info_map_frag.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

                    Toast.makeText(ctx, "관련 지역에 데이터가 없습니다.", Toast.LENGTH_SHORT).show()
                }

            }
            //Log.v("TAGG : size1 ", temp.size.toString()
        })
    }

    //내위치 post함수
    fun postMylocationResponse() {

        var jsonObject = JSONObject()
        jsonObject.put("la", latitude)
        jsonObject.put("lo", longitude)

        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject
        var networkService = networkService.postPlaceDistOrderCity(gsonObject)
        networkService.enqueue(object : Callback<GetMapPlaceAllResponse> {
            override fun onFailure(call: Call<GetMapPlaceAllResponse>, t: Throwable) {
                Log.e("내 위치 map fragment error", t.toString())
            }

            override fun onResponse(call: Call<GetMapPlaceAllResponse>, response: Response<GetMapPlaceAllResponse>) {
                if (response.isSuccessful) {
                    Log.e("내 위치 map success", response.body()!!.data.toString())

                    val temp: ArrayList<MapGetData> = response.body()!!.data
                    val status = response.body()!!.status

                    if (temp.size > 0) {
                        if (status == 200) {

                            var dataList: ArrayList<MapGetData> = temp

                            mapAdapter = InfoMapAdapter(activity!!, dataList)
                            rv_seoul_startup_info_map_frag.adapter = mapAdapter
                            rv_seoul_startup_info_map_frag.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
                        }
                    }
                }
            }
        })
    }

/*
        fun setRecyclerView(flag : Int) {
        var dataList: ArrayList<MapGetData> = ArrayList()

        mapAdapter = InfoMapAdapter(activity!!, dataList)
        rv_seoul_startup_info_map_frag.adapter = mapAdapter
        rv_seoul_startup_info_map_frag.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        if(flag == 0)
        {
            getMapFragmentResponse()
        }
        else{

        }
    }*/

/*
    fun mapsetOnClick() {

        btn_map_page_spot_gangseo.setOnClickListener {
            mapFlag(btn_map_page_spot_gangseo, btn_gangseo)
            //나머지 버튼들은 비활성화..! --> 배열로 집어 넣었으니 그거 생각해서 해보면 될듯
        }
    }

    private fun mapFlag(id: View, btn_flag: Int) {

        var flag = btn_flag

        if (flag == 1) {
            flag = 0
            id.isSelected = false
        } else {
            flag = 1
            id.isSelected = true
        }
        //나머지 btn_flag는 모두 비활성화 되도록 해야함....
    }
*/

    //위치 권한 확인
    private fun requestReadUserLocationPermission() {

        if (ContextCompat.checkSelfPermission(ctx, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
        ) {
            if (shouldShowRequestPermissionRationale(android.Manifest.permission.ACCESS_FINE_LOCATION)
            ) {
            } else {
                requestPermissions(arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
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

    //주소값 가져오기
    private fun makeAddress() {
        val geocoder = Geocoder(context, Locale.getDefault())

        try {
            address = geocoder.getFromLocation(
                    mylocation?.latitude ?: (-1).toDouble(),
                    mylocation?.longitude ?: (-1).toDouble(),
                    1
            )[0].getAddressLine(0)

            latitude = mylocation!!.latitude
            longitude = mylocation!!.longitude

            //Toast.makeText(context, "위도는!" + mylocation?.latitude.toString() + "경도는!" + mylocation?.longitude.toString(), Toast.LENGTH_LONG).show()


        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


/*    fun spinner() {

        var spinner_thema: AwesomeSpinner = R.id.spinner_thema_map_fragment as AwesomeSpinner

        var spinnerthemaArray = ArrayList<String>()
        spinnerthemaArray.add("전체")
        spinnerthemaArray.add("시창업센터")
        spinnerthemaArray.add("엔젤투자조합")
        spinnerthemaArray.add("엑셀러레이터")
        spinnerthemaArray.add("정부지원센터")
        spinnerthemaArray.add("미디어")
        spinnerthemaArray.add("대학창업센터")
        spinnerthemaArray.add("파트너스")
        spinnerthemaArray.add("네트워크")
        spinnerthemaArray.add("벤처캐피탈")

        val themaAdapter = ArrayAdapter<String>(ctx, android.R.layout.simple_spinner_item, spinnerthemaArray)

        spinner_thema.setAdapter(themaAdapter)

        spinner_thema.setOnSpinnerItemClickListener(
                AwesomeSpinner.onSpinnerItemClickListener { position, itemAtPosition ->
                    var thema = position
                })
    }*/


}
