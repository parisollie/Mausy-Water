package com.pjff.mausy_water.Fragmentos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.pjff.mausy_water.R
import com.pjff.mausy_water.databinding.ActivityFragmentoBinding

class FragmentoActivity : AppCompatActivity() {
    lateinit var binding: ActivityFragmentoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFragmentoBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_fragmento)
        setContentView(binding.root)
        //Por si hace click en un boton u otro
        binding.fragment1Bt.setOnClickListener{
            replaceFragment(Fragment1())
        }
        binding.fragment2Bt.setOnClickListener{
            replaceFragment(Fragment2())

        }
    }

    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }
}