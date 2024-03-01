package com.example.mvvmmodel.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmmodel.Repository.QuotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import models.QuoteList

class MainViewModel(private val repository: QuotesRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getQuotes(1)
        }

    }

    val quotes : LiveData<QuoteList>
        get() = repository.quotes
}