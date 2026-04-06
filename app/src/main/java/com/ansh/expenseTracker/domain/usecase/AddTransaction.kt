package com.ansh.expenseTracker.domain.usecase

import com.ansh.expenseTracker.domain.model.Transaction
import com.ansh.expenseTracker.domain.repository.TransactionRepository

class AddTransaction(
    private val repository: TransactionRepository
) {
    suspend operator fun invoke(transaction: Transaction): Long = repository.insert(transaction = transaction)
}