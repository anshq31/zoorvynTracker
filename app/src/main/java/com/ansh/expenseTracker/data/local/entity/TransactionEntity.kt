package com.ansh.expenseTracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactions")
data class TransactionEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val amount: Double,
    val type: String,      // "Income" or "Expense"
    val category: String,
    val date: Long,
    val notes: String?
)
