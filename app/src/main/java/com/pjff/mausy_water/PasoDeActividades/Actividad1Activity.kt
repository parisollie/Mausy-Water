package com.pjff.mausy_water.PasoDeActividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.pjff.mausy_water.R

class Actividad1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad1)
        /*Le decimos que llegaremos a la actividad 2
        * debemos tener un boton en la primera actividad */


        val button1 = findViewById<Button>(R.id.btnIntentoToActivityTwo)

        button1.setOnClickListener{
            startActivity(Intent(this,Actividad2Activity::class.java))

        }
    }
}