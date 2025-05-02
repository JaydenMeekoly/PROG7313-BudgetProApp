package com.example.budgetproapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.budgetproapp.data.dao.ExpenseDao
import com.example.budgetproapp.data.entities.Expense
import com.example.budgetproapp.data.repository.ExpenseRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class ExpenseRepositoryTest {

    private lateinit var expenseDao: ExpenseDao
    private lateinit var repository: ExpenseRepository

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        expenseDao = mock(ExpenseDao::class.java)
        repository = ExpenseRepository(expenseDao)
    }

    @Test
    fun `insertExpense calls insert on DAO`() = runBlocking {
        val expense = Expense(0, "Lunch", 30.0, "2025-05-01", "Sandwich")

        repository.insertExpense(expense)

        verify(expenseDao, times(1)).insert(expense)
    }

    @Test
    fun `getAllExpenses returns LiveData from DAO`() {
        repository.getAllExpenses()
        verify(expenseDao, times(1)).getAllExpenses()
    }
}
