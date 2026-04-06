package com.ansh.expenseTracker.domain.usecase

import com.ansh.expenseTracker.domain.model.Transaction
import com.ansh.expenseTracker.domain.repository.TransactionRepository
import javax.inject.Inject

class UpdateTransaction @Inject constructor(
    private val repository: TransactionRepository
) {
    suspend operator fun invoke(transaction: Transaction)= repository.update(transaction)
}