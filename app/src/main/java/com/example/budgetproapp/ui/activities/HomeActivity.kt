package com.example.budgetproapp.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.budgetproapp.databinding.ActivityHomeBinding
import com.example.budgetproapp.ui.activities.ViewExpenseActivity
import com.example.budgetproapp.ui.addexpense.AddExpenseActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddExpense.setOnClickListener {
            startActivity(Intent(this, AddExpenseActivity::class.java))
        }

        binding.btnViewExpenses.setOnClickListener {
            startActivity(Intent(this, ViewExpenseActivity::class.java))
        }
    }
}
