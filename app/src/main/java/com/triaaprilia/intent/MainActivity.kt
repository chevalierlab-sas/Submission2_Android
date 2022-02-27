package com.triaaprilia.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.triaaprilia.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener{
            val username = binding.edtUsername.text.toString()
            val email = binding.edtEmail.text.toString()
            val phoneNumber = binding.edtPhoneNumber.text.toString()
            when{
                TextUtils.isEmpty(username) -> {
                    Toast.makeText(this, "input username", Toast.LENGTH_SHORT).show()
                    binding.edtUsername.requestFocus()
                }
                TextUtils.isEmpty(email) -> {
                    Toast.makeText(this, "input email", Toast.LENGTH_SHORT).show()
                    binding.edtEmail.requestFocus()
                }
                TextUtils.isEmpty(phoneNumber) -> {
                    Toast.makeText(this, "input phoneNumber", Toast.LENGTH_SHORT).show()
                    binding.edtPhoneNumber.requestFocus()
                }
                else -> {
                    val user = User(
                        username,
                        email,
                        phoneNumber
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