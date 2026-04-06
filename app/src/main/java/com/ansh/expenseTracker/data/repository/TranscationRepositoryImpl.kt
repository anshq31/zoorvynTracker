package com.ansh.expenseTracker.data.repository

import com.ansh.expenseTracker.data.local.dao.TransactionDao
import com.ansh.expenseTracker.data.local.entity.TransactionEntity
import com.ansh.expenseTracker.domain.model.Transaction
import com.ansh.expenseTracker.domain.model.TransactionType
import com.ansh.expenseTracker.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TransactionRepositoryImpl @Inject constructor(
    private val dao: TransactionDao
): TransactionRepository{
    override fun getAllTransactions(): Flow<List<Transaction>> {
        return dao.getAllTransactions().map { entities -> entities.map { it.toDomain() } }
    }

    override suspend fun insert(transaction: Transaction): Long {
        return dao.insert(transaction.toEntity())
    }

    override suspend fun update(transaction: Transaction){
        return dao.update(transaction.toEntity())
    }

    override suspend fun delete(transaction: Transaction) {
        dao.delete(transaction.toEntity())
    }

    private fun TransactionEntity.toDomain(): Transaction{
        return Transaction(
            id = id,
            amount = amount,
            category = category,
            date = date,
            type = when(type.uppercase()){
                "INCOME" -> TransactionType.INCOME
                "EXPENSE" -> TransactionType.EXPENSE
                else -> throw IllegalArgumentException("Unknown transaction type: $type")
            },
            notes = notes,
        )
    }

    private fun Transaction.toEntity(): TransactionEntity{
        return TransactionEntity(
            id = id,
            amount = amount,
            category = category,
            date = date,
            type = type.name,
            notes = notes,
        )
    }
}