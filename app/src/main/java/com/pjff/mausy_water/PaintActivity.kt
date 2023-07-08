package com.pjff.mausy_water

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PaintActivity : AppCompatActivity() {
    //Pintamos nuestros valores
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paint)
        //Recibimos los valores
        val textview1 = findViewById<TextView>(R.id.Componente1)
        val textview2 = findViewById<TextView>(R.id.Componente2)
        val textview3 = findViewById<TextView>(R.id.Componente3)
        val textview4 = findViewById<TextView>(R.id.Componente4)
        val textview5 = findViewById<TextView>(R.id.Componente5)
        val textview6 = findViewById<TextView>(R.id.Componente6)
        val textview7 = findViewById<TextView>(R.id.Componente7)


        val receivedMessage:String = intent.extras?.getString("EXTRA_MESSAGE").orEmpty()
        val receivedMessage2:String = intent.extras?.getString("EXTRA_MESSAGE1").orEmpty()
        val receivedMessage3:String = intent.extras?.getString("EXTRA_MESSAGE2").orEmpty()
        val receivedMessage4:String = intent.extras?.getString("EXTRA_MESSAGE3").orEmpty()
        val receivedMessage5:String = intent.extras?.getString("EXTRA_MESSAGE5").orEmpty()
        val receivedMessage6:String = intent.extras?.getString("EXTRA_MESSAGE6").orEmpty()
       val receivedMessage7:String = intent.extras?.getString("EXTRA_MESSAGE8").orEmpty()


        textview1.text = receivedMessage.toString()
        textview2.text = receivedMessage2.toString()
        textview3.text = receivedMessage3.toString()
        textview4.text = receivedMessage4.toString()
        textview5.text = receivedMessage5.toString()
        textview6.text = receivedMessage6.toString()
        textview7.text = receivedMessage7.toString()

    }

}
