package com.example.budgetproapp.data.repository

import android.content.Context
import com.example.budgetproapp.data.dao.ExpenseDao
import com.example.budgetproapp.data.database.AppDatabase
import com.example.budgetproapp.data.entities.Expense
import androidx.lifecycle.LiveData

class ExpenseRepository(private val expenseDao: ExpenseDao)
{

    // Remove suspend here since LiveData is being returned directly
    fun getAllExpenses(): LiveData<List<Expense>> = expenseDao.getAllExpenses()

    suspend fun insertExpense(expense: Expense) {
        expenseDao.insert(expense)  // Correct method name for insertion
    }

    companion object {
        @Volatile
        private var INSTANCE: ExpenseRepository? = null

        fun getInstance(context: Context): ExpenseRepository {
            return INSTANCE ?: synchronized(this) {
                val db = AppDatabase.getDatabase(context)
                val instance = ExpenseRepository(db.expenseDao())
                INSTANCE = instance
                instance
            }
        }
    }
}
/*
 * References
 * ----------
 *
 * Android Developers.  Room Persistence Library. https://developer.android.com/training/data-storage/room
 *
 * Android Developers.  Room Repository. https://developer.android.com/topic/architecture/data-layer#repository
 *
 * Android Developers.  LiveData. https://developer.android.com/reference/androidx/lifecycle/LiveData
 *
 * Android Developers.  Volatile. https://developer.android.com/kotlin/coroutines/coroutines-adv#volatile
 *
 * Android Developers.  Room DAO. https://developer.android.com/reference/androidx/room/Dao
 *
 */
