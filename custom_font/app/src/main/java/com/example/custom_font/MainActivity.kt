package com.example.custom_font

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var list_item = mutableListOf<ListViewModel>()
        list_item.add(ListViewModel("a","1"))
        list_item.add(ListViewModel("B","2"))
        list_item.add(ListViewModel("C","3"))
        list_item.add(ListViewModel("D","4"))

        var listview = findViewById<ListView>(R.id.mainlistview)

        var listadapter = ListViewAdapter(list_item)
        // listview_item.xml과 activity_main.xml 연결
        listview.adapter = listadapter
    }
}