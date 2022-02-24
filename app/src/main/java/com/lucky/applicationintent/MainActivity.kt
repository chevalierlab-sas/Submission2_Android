package com.lucky.applicationintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.lucky.applicationintent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener(){
            val name = binding.edtName.text.toString()
            val email = binding.edtEmail.text.toString()
            val telepon = binding.edtTelepon.text.toString()

            when{
                TextUtils.isEmpty(name) -> {
                    Toast.makeText(this, "Masukan Nama", Toast.LENGTH_SHORT).show()
                    binding.edtName.requestFocus()
                }
                TextUtils.isEmpty(email) -> {
                    Toast.makeText(this, "Masukan E-mail", Toast.LENGTH_SHORT).show()
                    binding.edtEmail.requestFocus()
                }
                TextUtils.isEmpty(telepon) -> {
                    Toast.makeText(this, "Masukan Telepon", Toast.LENGTH_SHORT).show()
                    binding.edtTelepon.requestFocus()
                }
                else -> {
                    val user = User(
                        name, email, telepon
                    )
                    val intent = Intent(this@MainActivity, SecondActivity::class.java).apply {
                        putExtra(SecondActivity.USER,user)
                    }
                    startActivity(intent)
                }
            }
        }
    }
}