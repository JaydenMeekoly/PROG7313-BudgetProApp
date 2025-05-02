package com.example.budgetproapp.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.budgetproapp.data.entities.Expense
import com.example.budgetproapp.data.repository.ExpenseRepository
import com.example.budgetproapp.databinding.ActivityViewExpenseBinding
import com.example.budgetproapp.ui.adapters.ExpenseAdapter

class ViewExpenseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewExpenseBinding
    private lateinit var repository: ExpenseRepository
    private lateinit var adapter: ExpenseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the repository and adapter
        repository = ExpenseRepository.getInstance(this)
        adapter = ExpenseAdapter()

        // Set up the RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Observe LiveData from the repository
        observeExpenses()
    }

    private fun observeExpenses() {
        // Directly observe LiveData and update the adapter when data changes
        repository.getAllExpenses().observe(this, Observer { expenses ->
            // Update the adapter with the list of expenses when the LiveData changes
            expenses?.let {
                adapter.submitList(it)
            }
        })
    }
}
