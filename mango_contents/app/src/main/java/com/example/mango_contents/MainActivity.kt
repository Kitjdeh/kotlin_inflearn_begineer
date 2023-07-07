package com.example.mango_contents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentsModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bookmarkButton = findViewById<TextView>(R.id.bookmarkBtn)

        bookmarkButton.setOnClickListener {
            val intent = Intent(this, BookmarkActivity::class.java)
            startActivity(intent)
        }

        items.add(
            ContentsModel(
                "https://www.wkorea.com/2023/06/21/%eb%89%b4%ec%a7%84%ec%8a%a4-%ed%95%98%eb%8b%88-%ea%b5%ac%ec%b0%8c-%ea%b7%b8%eb%a6%ac%ea%b3%a0-%ea%b2%bd%eb%b3%b5%ea%b6%81/",
                "https://img.wkorea.com/w/2023/06/style_649146f02427b-500x354-1687242890.jpg",
                "아이유와 구찌의 약속된 만남"
            )
        )
        items.add(
            ContentsModel(
                "https://www.wkorea.com/2023/05/26/summer-fever/",
                "https://img.wkorea.com/w/2023/05/style_646daeabd1a85-500x354-1684919687.jpg",
                "에스파의 핫서머 화보"
            )
        )
        items.add(
            ContentsModel(
                "https://www.wkorea.com/2023/06/21/%eb%89%b4%ec%a7%84%ec%8a%a4-%ed%95%98%eb%8b%88-%ea%b5%ac%ec%b0%8c-%ea%b7%b8%eb%a6%ac%ea%b3%a0-%ea%b2%bd%eb%b3%b5%ea%b6%81/",
                "https://img.wkorea.com/w/2023/06/style_64914547cd889-500x354-1687242339.jpg",
                "신민아와 구찌가 \n 경복궁을 밝히는 일"
            )
        )
        items.add(
            ContentsModel(
                "https://www.wkorea.com/2023/06/21/%ec%8b%a0%eb%af%bc%ec%95%84%ec%99%80-%ea%b5%ac%ec%b0%8c%ea%b0%80-%ea%b2%bd%eb%b3%b5%ea%b6%81%ec%9d%84-%eb%b0%9d%ed%9e%88%eb%8a%94-%ec%9d%bc/",
                "https://img.wkorea.com/w/2023/06/style_6491493dd0b27-500x354-1687244540.jpg",
                "뉴진스 하니, 구찌 그리고 경복궁"
            )
        )
        items.add(
            ContentsModel(
                "https://www.wkorea.com/2023/06/21/%eb%89%b4%ec%a7%84%ec%8a%a4-%ed%95%98%eb%8b%88-%ea%b5%ac%ec%b0%8c-%ea%b7%b8%eb%a6%ac%ea%b3%a0-%ea%b2%bd%eb%b3%b5%ea%b6%81/",
                "https://img.wkorea.com/w/2023/06/style_649146f02427b-500x354-1687242890.jpg",
                "아이유와 구찌의 약속된 만남"
            )
        )
        items.add(
            ContentsModel(
                "https://www.wkorea.com/2023/05/26/summer-fever/",
                "https://img.wkorea.com/w/2023/05/style_646daeabd1a85-500x354-1684919687.jpg",
                "에스파의 핫서머 화보"
            )
        )
        items.add(
            ContentsModel(
                "https://www.wkorea.com/2023/06/21/%eb%89%b4%ec%a7%84%ec%8a%a4-%ed%95%98%eb%8b%88-%ea%b5%ac%ec%b0%8c-%ea%b7%b8%eb%a6%ac%ea%b3%a0-%ea%b2%bd%eb%b3%b5%ea%b6%81/",
                "https://img.wkorea.com/w/2023/06/style_64914547cd889-500x354-1687242339.jpg",
                "신민아와 구찌가\n경복궁을 밝히는 일"
            )
        )
        items.add(
            ContentsModel(
                "https://www.wkorea.com/2023/06/21/%ec%8b%a0%eb%af%bc%ec%95%84%ec%99%80-%ea%b5%ac%ec%b0%8c%ea%b0%80-%ea%b2%bd%eb%b3%b5%ea%b6%81%ec%9d%84-%eb%b0%9d%ed%9e%88%eb%8a%94-%ec%9d%bc/",
                "https://img.wkorea.com/w/2023/06/style_6491493dd0b27-500x354-1687244540.jpg",
                "뉴진스 하니, 구찌 그리고 경복궁"
            )
        )
        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext, items)
        recyclerview.adapter = rvAdapter

        rvAdapter.itemClick = object : RVAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(baseContext, ViewActivity::class.java)
                //url 저장
                intent.putExtra("url", items[position].url)
                //title 저장
                intent.putExtra("title", items[position].titleText)
                intent.putExtra("imageUrl", items[position].ImageUrl)
                startActivity(intent)
            }
        }

        // 만약 grid 2줄 형태로 원하면 GridLayout으로 설정하면 된다.
        recyclerview.layoutManager = GridLayoutManager(this, 2)
    }
}