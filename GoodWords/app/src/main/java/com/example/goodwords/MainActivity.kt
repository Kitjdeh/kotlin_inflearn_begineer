package com.example.goodwords

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.goodwords.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sentenceList = mutableListOf<String>()
        sentenceList.add("검정화면에 대충 흰글씨 쓰면 명언이지")
        sentenceList.add("돈으로 해결 못했다면 돈이 부족한게 아닌지 생각해라")
        sentenceList.add("계란을 한 바구니에 담지 마라")
        sentenceList.add("껐다 켜봤어?")
        sentenceList.add("왜지?")
        sentenceList.add("뭐지?")

        Log.d("MainActivity",sentenceList.random())

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.showAllSentenceBtn.setOnClickListener {
            val intent = Intent(this, SentenceActivity::class.java)
            startActivity(intent)
        }
        // 랜덤 단어 text값 할당
        binding.goodWordTextArea.setText(sentenceList.random())
    }
}