package com.example.diet_memo

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.time.Month
import java.time.Year
import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar

class MainActivity : AppCompatActivity() {
    val dataModelList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val database = Firebase.database
        val myRef = database.getReference("myMemo")

        val listView = findViewById<ListView>(R.id.mainLV)

        val adapter_list = ListViewAdapter(dataModelList)
        listView.adapter = adapter_list
        myRef.child(Firebase.auth.currentUser!!.uid)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    // 데이터가 추가 될 때 마다 리스트에 add가 일어나니 그전꺼는 다 밀어야함
                    dataModelList.clear()
                    for (dataModel in snapshot.children) {
                        dataModelList.add(dataModel.getValue(DataModel::class.java)!!)
                    }
                    //비동기로 받은 데이터를 새롭게 갱신하라 -> 리액트 useeffect나 플러터 futurebuilder 같은
                    adapter_list.notifyDataSetChanged()
//                Log.d("DataModel", dataModelList.toString())
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })

        val writeButton = findViewById<ImageView>(R.id.writeBtn)
        writeButton.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("운동 메모 다이얼로그")

            val mAlertDialog = mBuilder.show()

            val DateSelectBtn = mAlertDialog.findViewById<Button>(R.id.date_select)

            var dateText = ""
            DateSelectBtn?.setOnClickListener {
                DateSelectBtn
                val today = GregorianCalendar()
                val year: Int = today.get(Calendar.YEAR)
                val month: Int = today.get(Calendar.MONTH)
                val date: Int = today.get(Calendar.DATE)

                val dlg = DatePickerDialog(
                    this,
                    object : DatePickerDialog.OnDateSetListener {
                        override fun onDateSet(
                            view: DatePicker?,
                            year: Int,
                            month: Int,
                            dayOfMonth: Int
                        ) {
                            Log.d("MAIN", "${year}, ${month + 1}, ${dayOfMonth}")
                            DateSelectBtn.setText("${year}, ${month + 1}, ${dayOfMonth}")

                            dateText = "${year}, ${month + 1}, ${dayOfMonth}"
                        }
                    }, year, month, date
                ).show()
            }
            val saveBtn = mAlertDialog.findViewById<Button>(R.id.saveBtn)
            saveBtn?.setOnClickListener {
                // Write a message to the database
                val memo = mAlertDialog.findViewById<EditText>(R.id.memo)?.text.toString()
                val database = Firebase.database
                val myRef = database.getReference("myMemo").child(Firebase.auth.currentUser!!.uid)
                //미리 DataModel 세팅해야함
                val model = DataModel(dateText, memo)

                myRef.push().setValue(model)
            }
        }

    }
}