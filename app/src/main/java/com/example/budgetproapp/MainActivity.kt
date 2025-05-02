package com.example.budgetproapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.budgetproapp.ui.activities.WelcomeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Navigate directly to Welcome screen
        val intent = Intent(this, WelcomeActivity::class.java)
        startActivity(intent)
        finish() // Prevent back navigation to this launcher
    }
}
