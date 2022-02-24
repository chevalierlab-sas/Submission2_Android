package com.ghivalhrvnsyah.inten

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ghivalhrvnsyah.inten.databinding.ActivityPageTwoBinding

class PageTwo : AppCompatActivity() {
    private lateinit var binding: ActivityPageTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.hasExtra("name")){
            val name = intent.getStringExtra("name")
            val username = intent.getStringExtra("username")
            val  email = intent.getStringExtra("email")
            val phone = intent.getStringExtra("phone")

            binding.viewName.text = name.toString()
            binding.viewUsername.text = username.toString()
            binding.viewEmail.text = email.toString()
            binding.viewPhone.text = phone.toString()

        }


    }

}