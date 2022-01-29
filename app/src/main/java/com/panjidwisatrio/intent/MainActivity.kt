package com.panjidwisatrio.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.panjidwisatrio.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener() {
            val name = binding.edtName.text.toString()
            val email = binding.edtEmail.text.toString()
            val phoneNumber = binding.edtPhoneNumber.text.toString()

            when {
                TextUtils.isEmpty(name) -> {
                    Toast.makeText(this, "Masukan nama", Toast.LENGTH_SHORT).show()
                    binding.edtName.requestFocus()
                }
                TextUtils.isEmpty(email) -> {
                    Toast.makeText(this, "Masukan email", Toast.LENGTH_SHORT).show()
                    binding.edtEmail.requestFocus()
                }
                TextUtils.isEmpty(phoneNumber) -> {
                    Toast.makeText(this, "Masukan nomor telepon", Toast.LENGTH_SHORT).show()
                    binding.edtPhoneNumber.requestFocus()
                }
                else -> {
                    val user = User(
                        name,
                        email,
                        phoneNumber
                    )

                    val intent = Intent(this@MainActivity, SecondActivity::class.java).apply {
                        putExtra(SecondActivity.USER, user)
                    }
                    startActivity(intent)
                }
            }
        }
    }
}