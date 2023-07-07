package com.example.goodwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class SentenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sentence)

        val sentenceList = mutableListOf<String>()
        sentenceList.add("검정화면에 대충 흰글씨 쓰면 명언이지")
        sentenceList.add("돈으로 해결 못했다면 돈이 부족한게 아닌지 생각해라")
        sentenceList.add("계란을 한 바구니에 담지 마라")
        sentenceList.add("껐다 켜봤어?")
        sentenceList.add("왜지?")
        sentenceList.add("뭐지?")

        val sentenceAdapter = ListViewAdapter(sentenceList)
        val listview = findViewById<ListView>(R.id.sentenceListView)

        listview.adapter = sentenceAdapter
    }
}