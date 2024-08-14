package com.example.test2.kotlin.model.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.test2.kotlin.model.MainViewModel

class MainViewModelFactory(private val countReserved:Int): Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(countReserved) as T
    }
}
