package com.example.mango_contents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class BookmarkActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    // DB에서 받아 온 값을 넣을 빈 리스트 생성
    private val contentModels = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)

        // 북마크를 recycler에 넣을 adapter 호출
        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext, contentModels)
        recyclerview.adapter = rvAdapter

        recyclerview.layoutManager = GridLayoutManager(this, 2)

        val database = Firebase.database
        val mybookmarkRef = database.getReference("bookmark_ref")

        mybookmarkRef.child(auth.currentUser?.uid.toString())
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (dataModel in snapshot.children) {
                        contentModels.add(dataModel.getValue(ContentsModel::class.java)!!)
                    }
                    //adapter에 변화가 생긴 걸 동기화 처리해야함
                    rvAdapter.notifyDataSetChanged()
                }

                //실패할 경우 예외 처리
                override fun onCancelled(error: DatabaseError) {
                    Log.e("Bookmark", "dbError")
                }
            })
    }
}