package com.example.menu_practice

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var baseLayout : LinearLayout
    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        title = "Change Background"
        baseLayout = findViewById<LinearLayout>(R.id.baseLayout)
        button = findViewById<Button>(R.id.button)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var mInflater = menuInflater
        mInflater.inflate(R.menu.menu_option, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.red -> {
                baseLayout.setBackgroundColor(Color.RED)
            }
            R.id.blue -> {
                baseLayout.setBackgroundColor(Color.BLUE)
            }
            R.id.green -> {
                baseLayout.setBackgroundColor(Color.GREEN)
            }
            R.id.subRotate -> {
                button.rotation = 45f
            }
            R.id.subSize -> {
                button.scaleX = 2f
            }
        }
        return super.onOptionsItemSelected(item)
    }
}