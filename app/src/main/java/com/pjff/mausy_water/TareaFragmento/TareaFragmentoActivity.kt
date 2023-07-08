package com.pjff.mausy_water.TareaFragmento

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.pjff.mausy_water.Fragmentos.Fragment1
import com.pjff.mausy_water.Fragmentos.Fragment2
import com.pjff.mausy_water.PaintActivity
import com.pjff.mausy_water.R
import com.pjff.mausy_water.RegistroFormularioActivity
import com.pjff.mausy_water.databinding.ActivityTareaFragmentoBinding

class TareaFragmentoActivity : AppCompatActivity() {
    lateinit var binding: ActivityTareaFragmentoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTareaFragmentoBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_tarea_fragmento)
        setContentView(binding.root)

        emailFocusListener()
        passwordFocusListener()
        binding.fragment1Bt.setOnClickListener { submitForm() }


        //Por si hace click en un boton u otro
        binding.fragment1Bt.setOnClickListener {
            replaceFragment(Fragment1p())
            var message = "Email: " + binding.correoTar.text
            var message2 = "\nPassword: " + binding.contraseniaTar.text


            //Mandamos a pintar nuestra Actividad
            val sendMessage = Intent(this, PaintActivity::class.java)
            //Le mandamos el mensaje
            sendMessage.putExtra("EXTRA_MESSAGE", message)
            sendMessage.putExtra("EXTRA_MESSAGE1", message2)
            startActivity(sendMessage)


        }
        binding.fragment2Bt.setOnClickListener {
            replaceFragment(Fragment2p())

            //En caso de que toque el boton de registro

            startActivity(Intent(this, RegistroFormularioActivity::class.java))

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }


    private fun passwordFocusListener() {
        binding.contraseniaTar.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.passwordContainer.helperText = validPassword()
            }

        }
    }

    //Ponemos nuetras validaciones
    private fun validPassword(): String? {
        val passwordText = binding.contraseniaTar.text.toString()

        if (passwordText.length < 8) {
            return "Son 8 letras necesarias"
        }
        if (!passwordText.matches(".*[A-Z].*".toRegex())) {
            return "Debe contener una letra mayúscula"
        }
        if (!passwordText.matches(".*[a-z].*".toRegex())) {
            return "Debe contener una letra minuscula"
        }
        if (!passwordText.matches(".*[@#\$%^&+=].*".toRegex())) {
            return "Debe contener un carácter especial (@#\$%^&+=s)"
        }
        return null
    }

    private fun submitForm() {

        binding.emailContainer.helperText = validEmail()
        binding.passwordContainer.helperText = validPassword()


        val validEmail = binding.emailContainer.helperText == null
        val validPassword = binding.passwordContainer.helperText == null


        if (validEmail && validPassword)

            Fragment1p()
        else
            invalidForm()
    }

    private fun invalidForm() {
        var message = ""
        if (binding.emailContainer.helperText != null)
            message += "\n\nEmail: " + binding.emailContainer.helperText
        if (binding.passwordContainer.helperText != null)
            message += "\n\nPhone: " + binding.passwordContainer.helperText


        AlertDialog.Builder(this)
            .setTitle("Formulario Invalido")
            .setMessage(message)
            .setPositiveButton("okay") { _, _ ->
                //Do nothing
            }
            .show()
    }

    /*private fun resetForm() {


        var message = "Email: " + binding.correoTar.text
        var message2 = "\nPassword: " + binding.contraseniaTar.text


        //Mandamos a pintar nuestra Actividad
        val sendMessage = Intent(this, PaintActivity::class.java)
        //Le mandamos el mensaje
        sendMessage.putExtra("EXTRA_MESSAGE", message)
        sendMessage.putExtra("EXTRA_MESSAGE1", message2)



        startActivity(sendMessage)
    }*/


    private fun emailFocusListener() {
        binding.correoTar.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.emailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {
        val emailText = binding.correoTar.text.toString()

        if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
            return "!Invalido¡ Email agregado erróneamente"
        }
        return null
    }
}



