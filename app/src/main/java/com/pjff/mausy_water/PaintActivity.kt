package com.pjff.mausy_water

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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


        val receivedMessage:String = intent.extras?.getString("EXTRA_MESSAGE").orEmpty()
        val receivedMessage2:String = intent.extras?.getString("EXTRA_MESSAGE1").orEmpty()
        val receivedMessage3:String = intent.extras?.getString("EXTRA_MESSAGE2").orEmpty()
        val receivedMessage4:String = intent.extras?.getString("EXTRA_MESSAGE3").orEmpty()



        textview1.text = receivedMessage.toString()
        textview2.text = receivedMessage2.toString()
        textview3.text = receivedMessage3.toString()
        textview4.text = receivedMessage4.toString()


        val buttonreg = findViewById<Button>(R.id.btBack)

        buttonreg.setOnClickListener{
            startActivity(Intent(this, LoginPrincipalActivity::class.java))
        }

    }

}
