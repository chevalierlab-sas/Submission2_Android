package com.wahyuindra.intentexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wahyuindra.intentexample.databinding.ActivityPageTwoBinding

class PageTwo : AppCompatActivity() {
    private lateinit var binding : ActivityPageTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.hasExtra("name")){
            val name = intent.getStringExtra("name")
            val email = intent.getStringExtra("email")
            val noPhone = intent.getStringExtra("phone number")

            binding.tvName.text = name.toString()
            binding.tvEmail.text = email.toString()
            binding.tvPhone.text = noPhone.toString()
        }
    }
}