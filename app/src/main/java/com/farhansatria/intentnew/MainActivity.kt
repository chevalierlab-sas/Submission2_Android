package com.farhansatria.intentnew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.farhansatria.intentnew.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val userName = binding.edtUsername.text.toString()
            val phoneNumber = binding.edtPhonenumber.text.toString()
            val email = binding.edtEmail.text.toString()

            when {
                TextUtils.isEmpty(userName) -> {
                    Toast.makeText(this, "Input Username!", Toast.LENGTH_SHORT).show()
                    binding.edtUsername.requestFocus()
                }
                TextUtils.isEmpty(phoneNumber) -> {
                    Toast.makeText(this, "Input Phone Number!", Toast.LENGTH_SHORT).show()
                    binding.edtPhonenumber.requestFocus()
                }
                TextUtils.isEmpty(email) -> {
                    Toast.makeText(this, "Input Email!", Toast.LENGTH_SHORT).show()
                    binding.edtEmail.requestFocus()
                }
                else -> {
                    val user = User(
                        userName,
                        phoneNumber,
                        email
                    )

                    val intent = Intent(this@MainActivity, SecondActivity::class.java).apply{
                        putExtra(SecondActivity.USER, user)
                    }
                    startActivity(intent)
                }
            }
        }
    }
}