package com.example.projectintent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projectintent.databinding.ActivityMain2Binding
import com.example.projectintent.databinding.ActivityMain2Binding.inflate

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding:ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("name")){
            val name =intent.getStringExtra("name")
            val email =intent.getStringExtra("email")
            val phone =intent.getStringExtra("phone")

            binding.tvName.text=name.toString()
            binding.tvEmail.text=email.toString()
            binding.tvPhone.text=phone.toString()
        }
    }
}