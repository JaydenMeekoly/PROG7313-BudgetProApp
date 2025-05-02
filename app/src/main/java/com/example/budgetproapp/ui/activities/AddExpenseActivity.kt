package com.example.budgetproapp.ui.addexpense

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.budgetproapp.data.database.AppDatabase
import com.example.budgetproapp.data.entities.Expense
import com.example.budgetproapp.data.repository.ExpenseRepository
import com.example.budgetproapp.databinding.ActivityAddExpenseBinding
import kotlinx.coroutines.*

class AddExpenseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddExpenseBinding
    private lateinit var repository: ExpenseRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repository = ExpenseRepository.getInstance(this)

        binding.btnSave.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val amount = binding.amountEditText.text.toString().toDoubleOrNull()
            val date = binding.dateEditText.text.toString()
            val note = binding.noteEditText.text.toString()

            if (title.isNotEmpty() && amount != null && date.isNotEmpty()) {
                val expense = Expense(
                    title = title,
                    amount = amount,
                    date = date,
                    note = note
                )

                CoroutineScope(Dispatchers.IO).launch {
                    repository.insertExpense(expense)
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@AddExpenseActivity, "Expense added", Toast.LENGTH_SHORT).show()
                        finish()
                    }
                }
            } else {
                Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
/*
 * References
 * ----------
 *
 * Android Developers. (n.d.). AppCompatActivity. https://developer.android.com/reference/androidx/appcompat/app/AppCompatActivity
 *
 * Android Developers. (n.d.). Coroutines. https://developer.android.com/kotlin/coroutines
 *
 * Android Developers. (n.d.). Dispatchers. https://developer.android.com/reference/kotlinx/coroutines/Dispatchers
 *
 * Android Developers. (n.d.). Toast. https://developer.android.com/reference/android/widget/Toast
 *
 * Android Developers. (n.d.). View Binding. https://developer.android.com/topic/libraries/view-binding
 *
 */