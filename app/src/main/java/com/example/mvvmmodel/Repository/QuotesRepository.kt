package com.example.mvvmmodel.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmmodel.api.QuoteService
import models.QuoteList

class QuotesRepository(private val quoteService: QuoteService) {

    private val quotesLiveData = MutableLiveData<QuoteList>()

    val quotes: LiveData<QuoteList>
        get()  = quotesLiveData

    suspend fun getQuotes(page: Int){
        val result = quoteService.getQuotes(page)
        if(result!= null && result.body() != null)
        {
            quotesLiveData.postValue(result.body())
        }
    }
}