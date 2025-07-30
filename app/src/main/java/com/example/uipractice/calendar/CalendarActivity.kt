package com.example.uipractice.calendar

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.uipractice.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class CalendarActivity : AppCompatActivity() {

    private lateinit var calendarView: CalendarView
    private lateinit var tvSelectedDate: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        calendarView = findViewById(R.id.calendarView)
        tvSelectedDate = findViewById(R.id.tv_selected_date)

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance().apply {
                set(year, month, dayOfMonth)
            }

            val dayName = SimpleDateFormat("EEEE", Locale.getDefault()).format(calendar.time)
            val monthName = SimpleDateFormat("MMMM", Locale.getDefault()).format(calendar.time)

            val result = """
                You selected:
                Day: $dayName
                Date: $dayOfMonth
                Month: $monthName
                Year: $year
            """.trimIndent()

            tvSelectedDate.text = result
        }
    }

}