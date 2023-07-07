package com.example.databinding_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.databinding_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //2번 방식에 쓸 binding 정의
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //1번 방식 - findViewById
//        val btn = findViewById<Button>(R.id.testBtnId)
//        btn.setOnClickListener {
//            Toast.makeText(this,"click",Toast.LENGTH_LONG).show()
//        }

        //2번 방식 - DataBinding
        binding.testBtnId.setOnClickListener {
            Toast.makeText(this, "click!!!", Toast.LENGTH_LONG).show()
        }
    }
}