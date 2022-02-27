package com.silvy

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.silvy.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    companion object {
        const val USER = "user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(intent.hasExtra(USER)) {
            val user = intent.getParcelableExtra<User>(USER) as User

            binding.tvName.text = user.name.toString()
            binding.tvEmail.text = user.email.toString()
            binding.tvPhone.text = user.phone

            binding.tvEmail.setOnClickListener {
                val mail = Intent(Intent.ACTION_SENDTO)
                mail.data = Uri.parse("mailto:${user.email.toString()}")
                startActivity(mail)
            }

            binding.tvPhone.setOnClickListener {
                val dialPhone = Intent(Intent.ACTION_DIAL)
                dialPhone.data = Uri.parse("tel:${user.phone}")
                startActivity(dialPhone)
            }
        }
    }
}