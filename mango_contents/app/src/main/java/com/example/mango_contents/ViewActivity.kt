package com.example.mango_contents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class ViewActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        //유저 정보를 불러와야하니 firebase의 auth 부분 불러오기
        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val url = intent.getStringExtra("url").toString()
        val title = intent.getStringExtra("title").toString()
        val imageUrl = intent.getStringExtra("ImageUrl").toString()

        val saveText = findViewById<TextView>(R.id.savetext)

        val webView = findViewById<WebView>(R.id.webView)
        webView.loadUrl(
            intent.getStringExtra("url").toString()
        )
        // 데이터 베이스 부름
        val database = Firebase.database

        // 어디 경로에 저장할건지
        val myBookmarkRef = database.getReference("bookmark_ref")
        // 저장을 할 때 내 uid로 해야 유저에 따른 게시글 저장이 가능함

        saveText.setOnClickListener {
            myBookmarkRef
                .child(auth.currentUser!!.uid)
                .push()
                .setValue(ContentsModel(url, imageUrl, title))
        }
        Log.d("bookmark", "${url},${title} ,${auth.currentUser!!.uid}")

    }
}