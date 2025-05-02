package com.example.budgetproapp.ui.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.budgetproapp.data.entities.Expense
import com.example.budgetproapp.databinding.ItemExpenseBinding

class ExpenseAdapter : RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder>() {

    private val expenses = mutableListOf<Expense>()

    inner class ExpenseViewHolder(private val binding: ItemExpenseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(expense: Expense) {
            binding.tvTitle.text = expense.title
            binding.tvAmount.text = "R ${expense.amount}"
            binding.tvCategory.text = expense.category
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val binding = ItemExpenseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExpenseViewHolder(binding)
    }

    override fun getItemCount(): Int = expenses.size

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        holder.bind(expenses[position])
    }

    fun submitList(list: List<Expense>) {
        expenses.clear()
        expenses.addAll(list)
        notifyDataSetChanged()
    }
}
/*
 * References
 * ----------
 *
 * Android Developers.  RecyclerView. https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView
 *
 * Android Developers.  Adapter. https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView.Adapter
 *
 * Android Developers.  ViewHolder. https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView.ViewHolder
 *
 * Android Developers.  LayoutInflater. https://developer.android.com/reference/android/view/LayoutInflater
 *
 * Android Developers.  ViewGroup. https://developer.android.com/reference/android/view/ViewGroup
 *
 */