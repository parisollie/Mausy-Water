package com.pjff.mausy_water

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button

class LoginActivity : AppCompatActivity() {

    //se inicia con pjff18@gmail.com ,123456
    private val passEdt= findViewById<EditText>(R.id.editTextTextPassword)
    private val  loginbtn = findViewById<Button>(R.id.loginBtn)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


    }

}