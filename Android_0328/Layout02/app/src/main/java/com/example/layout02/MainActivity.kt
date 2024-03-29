package com.example.layout02

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        var tv1 : TextView
        var tv2 : TextView
        var tv3 : TextView

        tv1 = findViewById<TextView>(R.id.textView1)
        tv2 = findViewById<TextView>(R.id.textView2)
        tv3 = findViewById<TextView>(R.id.textView3)

        tv1.setText("TextView 연습")
        tv1.setTextColor(Color.BLUE)

        tv2.setTextSize(30.0f)
        tv2.setTypeface(android.graphics.Typeface.SERIF,
            android.graphics.Typeface.BOLD)

        tv3.setText("수원삼성우승")
        tv3.setTypeface(android.graphics.Typeface.SERIF)
    }

}