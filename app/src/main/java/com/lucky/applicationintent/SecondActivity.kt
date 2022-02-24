package com.lucky.applicationintent

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucky.applicationintent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    companion object{
        const val USER = "user"
    }
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra(USER)){
            val user = intent.getParcelableExtra<User>(USER) as User

            binding.tvName1.text = user.name.toString()
            binding.tvEmail1.text = user.email.toString()
            binding.tvTelepon1.text = user.telepon

            binding.tvEmail1.setOnClickListener{
                val email = Intent(Intent.ACTION_SENDTO)
                email.data = Uri.parse("mailto:${user.email.toString()}")
                startActivity(email)
            }
            binding.tvTelepon1.setOnClickListener {
                val telepon = Intent(Intent.ACTION_DIAL)
                telepon.data = Uri.parse("mailto:${user.telepon}")
                startActivity(telepon)
            }
        }
    }
}