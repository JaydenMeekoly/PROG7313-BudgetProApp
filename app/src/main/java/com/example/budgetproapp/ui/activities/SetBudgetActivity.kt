package com.example.budgetproapp.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.budgetproapp.databinding.ActivitySetBudgetBinding
import android.content.SharedPreferences
import android.preference.PreferenceManager

class SetBudgetActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySetBudgetBinding
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySetBudgetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefs = PreferenceManager.getDefaultSharedPreferences(this)

        // Load saved budget if it exists
        val savedBudget = prefs.getFloat("budget_goal", 0f)
        if (savedBudget > 0) {
            binding.etBudgetAmount.setText(savedBudget.toString())
        }

        binding.btnSaveBudget.setOnClickListener {
            val budgetText = binding.etBudgetAmount.text.toString()
            if (budgetText.isNotBlank()) {
                val budgetAmount = budgetText.toFloatOrNull()
                if (budgetAmount != null) {
                    prefs.edit().putFloat("budget_goal", budgetAmount).apply()
                    Toast.makeText(this, "Budget goal saved!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Invalid amount", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
