package com.example.mvvmmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmmodel.Repository.QuotesRepository
import com.example.mvvmmodel.api.QuoteService
import com.example.mvvmmodel.api.RetrofitHealper
import com.example.mvvmmodel.viewModels.MainViewModel
import com.example.mvvmmodel.viewModels.MainViewModelFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    lateinit var  mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val quoteService = RetrofitHealper.getInstance().create(QuoteService::class.java)

        val repository = QuotesRepository(quoteService)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this,{
            Log.d("NAYAN",it.results.toString())
        })
    }

}