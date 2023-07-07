package com.example.d_day

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.Calendar
import java.util.GregorianCalendar
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startBtn)
        val endButton = findViewById<Button>(R.id.endBtn)

        var startDate = ""
        var endDate = ""

        //calendar 인스턴스 생성
        val calendar_start = Calendar.getInstance()
        val calendar_end = Calendar.getInstance()

        startButton.setOnClickListener {
            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)
            val dlg = DatePickerDialog(
                this, object : DatePickerDialog.OnDateSetListener {
                    override fun onDateSet(
                        view: DatePicker?, year: Int, month: Int, dayOfMonth: Int
                    ) {
                        // 3일이면 03으로 맞춰야함 -> 2자리수 강제해야함
                        startDate = "${year}" + "${month}" + "${dayOfMonth}"

                        calendar_start.set(year, month, day)

                    }

                }, year, month, day
            )
            dlg.show()
        }

        endButton.setOnClickListener {
            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)
            val dlg = DatePickerDialog(
                this, object : DatePickerDialog.OnDateSetListener {
                    override fun onDateSet(
                        view: DatePicker?, year: Int, month: Int, dayOfMonth: Int
                    ) {
                        endDate = "${year}" + "${month}" + "${day}"
                        calendar_end.set(year, month, day)

                        // end타임과 start 타임을 초단위 변경
                        val finalDate =
                            TimeUnit.MILLISECONDS.toDays(calendar_end.timeInMillis - calendar_start.timeInMillis)

                        val textArea = findViewById<TextView>(R.id.finaldate)
//                        textArea.setText((endDate.toInt() - startDate.toInt() + 1).toString())
                        textArea.setText(finalDate.toString())
                    }
                }, year, month, day
            )
            dlg.show()
        }
    }
}