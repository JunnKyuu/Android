package com.example.layout04

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        val baseLayout = LinearLayout(this)
        baseLayout.orientation = LinearLayout.VERTICAL
        baseLayout.setBackgroundColor(Color.WHITE)
        setContentView(baseLayout, params)

        var edit = EditText(this)
        baseLayout.addView(edit)

        var btn = Button(this)
        btn.text = "버튼"
        btn.setBackgroundColor(Color.rgb(168,205,247))
        baseLayout.addView(btn)

        btn.setOnClickListener {
            Toast.makeText(
                applicationContext, "토스트로 생성된 메세지입니다.", Toast.LENGTH_SHORT
            ).show()
        }

    }
}