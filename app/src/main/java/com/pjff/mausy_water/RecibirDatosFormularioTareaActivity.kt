package com.pjff.mausy_water

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.pjff.mausy_water.R
import com.pjff.mausy_water.databinding.ActivityRecibirDatosFormularioTareaBinding

class RecibirDatosFormularioTareaActivity : AppCompatActivity() {


    private lateinit var binding: ActivityRecibirDatosFormularioTareaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecibirDatosFormularioTareaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        emailFocusListener()
        passwordFocusListener()
        nombreFocusListener()
        apellidoFocusListener()
        binding.botonTar.setOnClickListener {submitForm()}

    }

    private fun apellidoFocusListener() {
        binding.apellidoTar.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.ApellidoContainer.helperText = validApellido()
            }

        }
    }

    private fun validApellido(): String? {
        val phoneText = binding.nombreTar.text.toString()

        if(!phoneText.matches(".*[A-Za].*".toRegex())){
            return "El apellido debe contener sólo letras"
        }

        return null
    }

    private fun nombreFocusListener() {
        binding.nombreTar.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.nombreContainer.helperText = validName()
            }

        }
    }

    private fun validName(): String? {
        val phoneText = binding.nombreTar.text.toString()

        if(!phoneText.matches(".*[A-Za].*".toRegex())){
            return "El nombre debe contener sólo letras"
        }

        return null
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

        if (passwordText.length <8 ){
            return "Son 8 letras necesarias"
        }
        if(!passwordText.matches(".*[A-Z].*".toRegex())){
            return "Debe contener una letra mayúscula"
        }
        if(!passwordText.matches(".*[a-z].*".toRegex())){
            return "Debe contener una letra minuscula"
        }
        if(!passwordText.matches(".*[@#\$%^&+=].*".toRegex())){
            return "Debe contener un carácter especial (@#\$%^&+=s)"
        }
        return null
    }

    private fun submitForm() {

        binding.emailContainer.helperText = validEmail()
        binding.passwordContainer.helperText = validPassword()
        binding.nombreContainer.helperText = validName()
        binding.ApellidoContainer.helperText = validApellido()

        val validEmail = binding.emailContainer.helperText == null
        val validPassword = binding.passwordContainer.helperText == null
        val validName = binding.nombreContainer.helperText == null
        val validApe = binding.ApellidoContainer.helperText == null

        if(validEmail && validPassword && validName && validApe)
            resetForm()
        else
            invalidForm()
    }

    private fun invalidForm() {
        var message= ""
        if(binding.emailContainer.helperText != null)
            message += "\n\nEmail: " + binding.emailContainer.helperText
        if(binding.passwordContainer.helperText != null)
            message += "\n\nPhone: " + binding.passwordContainer.helperText
        if(binding.nombreContainer.helperText != null)
            message += "\n\nNombre: " + binding.nombreContainer.helperText
        if(binding.ApellidoContainer.helperText != null)
            message += "\n\nApellido: " + binding.ApellidoContainer.helperText

        AlertDialog.Builder(this)
            .setTitle("Formulario Invalido")
            .setMessage(message)
            .setPositiveButton("okay"){ _, _ ->
                //Do nothing
            }
            .show()
    }

    private fun resetForm() {


        var message = "Email: " + binding.correoTar.text
        var message2 = "\nPassword: " + binding.contraseniaTar.text
        var message3 = "\nNombre: " + binding.nombreTar.text
        var message4 = "\nApellido: " + binding.apellidoTar.text



        val sendMessage = Intent(this, PaintActivity::class.java)
        //Le mandamos el mensaje
        sendMessage.putExtra("EXTRA_MESSAGE", message)
        sendMessage.putExtra("EXTRA_MESSAGE1", message2)
        sendMessage.putExtra("EXTRA_MESSAGE2", message3)
        sendMessage.putExtra("EXTRA_MESSAGE3", message4)

        startActivity(sendMessage)

    }


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