package com.example.budgetproapp.data.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.budgetproapp.data.dao.ExpenseDao
import com.example.budgetproapp.data.entities.Expense

@Database(entities = [Expense::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "budget_db"
                ).build()
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
 * Android Developers. (n.d.). Room Database. https://developer.android.com/reference/androidx/room/Database
 *
 * Android Developers. (n.d.). Room RoomDatabase. https://developer.android.com/reference/androidx/room/RoomDatabase
 *
 * Android Developers. (n.d.). Room DatabaseBuilder. https://developer.android.com/reference/androidx/room/Room#databaseBuilder(android.content.Context,%20java.lang.Class%3CT,%20java.lang.String)
 *
 * Android Developers. (n.d.). Volatile. https://developer.android.com/kotlin/coroutines/coroutines-adv#volatile
 *
 * Android Developers. (n.d.). Synchronized. https://developer.android.com/kotlin/coroutines/coroutines-adv#synchronized
 *
 * Android Developers. (n.d.). Context. https://developer.android.com/reference/android/content/Context
 *
 * Android Developers. (n.d.). Application Context. https://developer.android.com/reference/android/content/Context#getApplicationContext()
 *
 */
