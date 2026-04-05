package com.ansh.expenseTracker.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ansh.expenseTracker.data.local.dao.TransactionDao
import com.ansh.expenseTracker.data.local.entity.TransactionEntity

@Database(
    entities = [TransactionEntity::class],
    version = 1)
abstract class ExpenseTrackerDB : RoomDatabase() {
    abstract fun transactionDao() : TransactionDao
}