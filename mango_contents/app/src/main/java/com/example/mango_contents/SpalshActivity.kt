package com.example.mango_contents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SpalshActivity : AppCompatActivity() {
    // FirebaseAUth의 인스턴스를 선언
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh)
        //onCreat() 메서드에서 FirebaseAuth 인스턴스를 초기화 한다.
        // Initialize Firebase Auth
        auth = Firebase.auth
        // 현재유저 정보의 uid 값이 존재하는지로 로그인 여부 확인
        //회원가입이 안되어있으므로 joinactivity로
        if (auth.currentUser?.uid == null) {
            Handler().postDelayed({
                startActivity(Intent(this, JoinActivity::class.java))
                finish()
            }, 3000)
        }
        //회원가입이 되어있으므로 MainActivity
        else {
            Handler().postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 3000)
        }
    }
}