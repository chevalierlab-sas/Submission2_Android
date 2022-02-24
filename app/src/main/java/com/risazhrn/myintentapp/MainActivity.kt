package com.risazhrn.myintentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.risazhrn.myintentapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener{
            val name = binding.edtName.text.toString()
            val email = binding.edtEmail.text.toString()
            val phoneNumber = binding.edtPhone.text.toString()

            val intent = Intent(this@MainActivity, PageTwo::class.java).apply {
                putExtra("name", name)
                putExtra("email", email)
                putExtra("phoneNumber", phoneNumber)
            }
            startActivity(intent)

        }
    }
}