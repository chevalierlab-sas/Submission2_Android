package com.chikalfachdiana.intentapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chikalfachdiana.intentapp.databinding.ActivityPage2Binding

class Page2 : AppCompatActivity() {
    private lateinit var binding: ActivityPage2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPage2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.hasExtra("nama")) {
            val name = intent.getStringExtra("name")
            val email = intent.getStringExtra("email")
            val phoneNumber = intent.getStringExtra("phoneNumber")

            binding.txtName.text = name.toString()
            binding.txtEmail.text = email.toString()
            binding.txtPhoneNumber.text = phoneNumber.toString()

            binding.txtEmail.setOnClickListener {
                val mail = Intent(Intent.ACTION_SENDTO)
                mail.data = Uri.parse("mailto:@email")
                startActivity(mail)
            }
            binding.txtPhoneNumber.setOnClickListener {
                val dialPhone = Intent(Intent.ACTION_DIAL)
                dialPhone.data = Uri.parse("mailto:phoneNumber")
                startActivity(dialPhone)
            }
        }
    }
}
