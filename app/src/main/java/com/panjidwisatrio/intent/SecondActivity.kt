package com.panjidwisatrio.intent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.panjidwisatrio.intent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    companion object {
        const val USER = "user"
    }

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (intent.hasExtra(USER)) {
            val user = intent.getParcelableExtra<User>(USER) as User

            binding.tvName.text = user.name.toString()
            binding.tvEmail.text = user.email.toString()
            binding.tvPhoneNumber.text = user.phoneNumber

            binding.tvEmail.setOnClickListener {
                val email = Intent(Intent.ACTION_SENDTO)
                email.data = Uri.parse("mailto:${user.email.toString()}")
                startActivity(email)
            }

            binding.tvPhoneNumber.setOnClickListener {
                val phone = Intent(Intent.ACTION_DIAL)
                phone.data = Uri.parse("tel:${user.phoneNumber}")
                startActivity(phone)
            }
        }
    }
}