package com.ansh.expenseTracker.domain.usecase

import com.ansh.expenseTracker.domain.model.Transaction
import com.ansh.expenseTracker.domain.repository.TransactionRepository
import javax.inject.Inject

class DeleteTransaction @Inject constructor(
    private val repository: TransactionRepository
) {
    suspend operator fun invoke(transaction: Transaction) = repository.delete(transaction)
}