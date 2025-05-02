package com.example.budgetproapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val amount: Double,
    val date: String,
    val note: String?,
    val category: String = "Uncategorized"
)
/*
 * References
 * ----------
 *
 * Android Developers.  Room Persistence Library. https://developer.android.com/training/data-storage/room
 *
 * Android Developers.  Room Entity. https://developer.android.com/reference/androidx/room/Entity
 *
 * Android Developers.  Room PrimaryKey. https://developer.android.com/reference/androidx/room/PrimaryKey
 *
 * Android Developers.  Define data using Room entities. https://developer.android.com/training/data-storage/room/defining-data
 *
 */