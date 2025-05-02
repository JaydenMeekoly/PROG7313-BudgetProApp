package com.example.budgetproapp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.budgetproapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoginSubmit.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            // Simple validation (no database in this step)
            if (email.isNotEmpty() && password.isNotEmpty()) {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
/*
 * References
 * ----------
 *
 * Android Developers.  AppCompatActivity. https://developer.android.com/reference/androidx/appcompat/app/AppCompatActivity
 *
 * Android Developers. Intent. https://developer.android.com/reference/android/content/Intent
 *
 * Android Developers.  Toast. https://developer.android.com/reference/android/widget/Toast
 *
 * Android Developers.  View Binding. https://developer.android.com/topic/libraries/view-binding
 *
 * Android Developers.  Activity. https://developer.android.com/reference/android/app/Activity
 *
 */