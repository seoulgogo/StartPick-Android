package com.seoulapp.startpick.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import com.seoulapp.startpick.R

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        setWebView() // 웹 뷰 세팅

    }

    /* 웹 뷰 세팅 */
    fun setWebView(){
        val webView = findViewById<View>(R.id.wv) as WebView
        val settings = webView.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.setSupportZoom(true)

        val link = intent.getStringExtra("link")
        webView.loadUrl(link)
    }
}
