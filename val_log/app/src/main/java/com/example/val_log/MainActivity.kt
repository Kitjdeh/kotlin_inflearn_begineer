package com.example.val_log

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val test = "여기는 테스트 값"
        Log.e("kitjdeh", test) // 오류
        Log.w("kitjdeh", test) // 경고
        Log.i("kitjdeh", test) // 정보
        Log.d("kitjdeh", test) // 디버그
        Log.v("kitjdeh", test) // 상세

    }
}