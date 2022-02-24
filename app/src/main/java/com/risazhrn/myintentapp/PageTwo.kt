package com.risazhrn.myintentapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.risazhrn.myintentapp.databinding.ActivityPageTwoBinding

class PageTwo : AppCompatActivity() {
    private lateinit var binding: ActivityPageTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("name")){
            val name = intent.getStringExtra("name")
            val email = intent.getStringExtra("email")
            val phoneNumber = intent.getStringExtra("phoneNumber")

            binding.tvName.text = name.toString()
            binding.tvEmail.text = email.toString()
            binding.tvPhone.text = phoneNumber.toString()

            binding.tvEmail.setOnClickListener{
                val mail = Intent(Intent.ACTION_SENDTO)
                mail.data = Uri.parse("mailto:$email")
                startActivity(mail)
            }
            binding.tvPhone.setOnClickListener{
                val dialPhone = Intent(Intent.ACTION_DIAL)
                dialPhone.data = Uri.parse("tel:$phoneNumber")
                startActivity(dialPhone)
            }
        }
    }
}