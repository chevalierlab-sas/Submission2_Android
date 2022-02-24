package com.farhansatria.intentnew

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.farhansatria.intentnew.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    companion object{
        const val USER = "user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (intent.hasExtra(USER)){
            val user = intent.getParcelableExtra<User>(USER) as User
            binding.tvUsername.text = user.userName.toString()
            binding.tvPhoneNumber.text = user.phoneNumber.toString()
            binding.tvEmail.text = user.email

            binding.tvEmail.setOnClickListener{
                val mail = Intent (Intent.ACTION_SENDTO)
                mail.data = Uri.parse("mailto:${user.email.toString()}")
                startActivity(mail)
            }
            binding.tvPhoneNumber.setOnClickListener {
                val phone = Intent(Intent.ACTION_DIAL)
                phone.data = Uri.parse("tel:${user.phoneNumber}")
                startActivity(phone)
            }
        }
    }
}