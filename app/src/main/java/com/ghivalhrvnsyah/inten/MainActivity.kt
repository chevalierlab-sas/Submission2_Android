package com.ghivalhrvnsyah.inten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ghivalhrvnsyah.inten.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener{
            val name = binding.edtName.text.toString()
            val username = binding.edtUsername.text.toString()
            val email = binding.edtEmail.text.toString()
            val phone = binding.edtPhone.text.toString()

            val intent = Intent(this@MainActivity, PageTwo::class.java).apply {
                putExtra("name", name)
                putExtra("username", username)
                putExtra("email", email)
                putExtra("phone", phone)
            }
            startActivity(intent)


        }
    }
}