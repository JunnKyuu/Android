package com.example.login_project

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var loginButton: android.widget.Button
    lateinit var textID: EditText
    lateinit var textPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        loginButton = findViewById(R.id.loginButton)
        textID = findViewById(R.id.textID)
        textPassword = findViewById(R.id.textPassword)

        // 로그인 버튼 클릭
        loginButton!!.setOnClickListener {
            val inputStudentID = textID!!.text.toString()
            val inputPassword = textPassword!!.text.toString()
            val studentID = "60222126"
            var password = "admin123"
            // 빈칸 제출시 Toast
            if (inputStudentID == "" || inputPassword == "") {
                Toast.makeText(this@MainActivity, "학번과 비밀번호를 모두 입력해주세요.", Toast.LENGTH_LONG).show()
            }
            else {
                // id 와 password 일치시
                if (inputStudentID == studentID && inputPassword == password) {
                    Toast.makeText(this@MainActivity, "로그인 되었습니다.", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this@MainActivity, "학번과 비밀번호를 확인해 주세요.", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}