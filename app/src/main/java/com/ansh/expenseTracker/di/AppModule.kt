package com.ansh.expenseTracker.di

import android.content.Context
import androidx.room.Room
import com.ansh.expenseTracker.data.local.dao.TransactionDao
import com.ansh.expenseTracker.data.local.db.ExpenseTrackerDB
import com.ansh.expenseTracker.data.repository.TransactionRepositoryImpl
import com.ansh.expenseTracker.domain.repository.TransactionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent ::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(appContext: Context): ExpenseTrackerDB =
        Room
        .databaseBuilder(
        appContext,
        ExpenseTrackerDB::class.java,
        "expensetracker_db"
        )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideTransactionDao(db: ExpenseTrackerDB) = db.transactionDao()

    @Provides
    @Singleton
    fun provideTransactionRepository(dao : TransactionDao): TransactionRepository {
         return TransactionRepositoryImpl(dao)
    }
}