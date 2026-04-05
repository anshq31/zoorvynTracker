package com.ansh.expenseTracker.presentation.transaction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ansh.expenseTracker.domain.model.Transaction
import com.ansh.expenseTracker.domain.usecase.GetAllTranscations
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val getAllTranscations: GetAllTranscations
): ViewModel() {
    init {
        getAllTransactions()
    }
    private val _transaction = MutableStateFlow<List<Transaction>>(emptyList())
    val transaction : StateFlow<List<Transaction>> = _transaction.asStateFlow()

    private fun getAllTransactions(){
        viewModelScope.launch {
            getAllTranscations().collect { _transaction.value = it }
        }
    }
}