package com.ansh.expenseTracker.domain.model

data class Transaction (
    val id: Long,
    val amount: Double,
    val type: TransactionType,
    val category: String,
    val date: Long,          // Timestamp
    val notes: String?
)

enum class TransactionType {
    INCOME, EXPENSE
}