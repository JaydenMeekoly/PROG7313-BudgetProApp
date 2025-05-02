package com.example.budgetproapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.budgetproapp.data.entities.Expense

@Dao
interface ExpenseDao {
    @Insert
    suspend fun insert(expense: Expense)  // Insert method is named `insert`

    @Query("SELECT * FROM expenses ORDER BY date DESC")
    fun getAllExpenses(): LiveData<List<Expense>>

    @Delete
    suspend fun delete(expense: Expense)
}
/*
 * References
 * ----------
 *
 * Android Developers. Room Persistence Library.  https://developer.android.com/training/data-storage/room
 *
 * Android Developers. Room DAO.  https://developer.android.com/reference/androidx/room/Dao
 *
 * Android Developers. Room Insert.  https://developer.android.com/reference/androidx/room/Insert
 *
 * Android Developers. Room Query.  https://developer.android.com/reference/androidx/room/Query
 *
 * Android Developers. Room Delete.  https://developer.android.com/reference/androidx/room/Delete
 *
 * Android Developers. Room LiveData.  https://developer.android.com/reference/androidx/lifecycle/LiveData
 *
 * Android Developers. Room Entity.  https://developer.android.com/reference/androidx/room/Entity
 *
 */