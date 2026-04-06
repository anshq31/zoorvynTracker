package com.ansh.expenseTracker.domain.usecase


import com.ansh.expenseTracker.domain.model.Transaction
import com.ansh.expenseTracker.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTranscations @Inject constructor(
    private val repostiory: TransactionRepository
) {
    operator fun invoke() : Flow<List<Transaction>> = repostiory.getAllTransactions()
}