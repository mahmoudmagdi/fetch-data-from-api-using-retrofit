package com.khlafawi.movieretrofit.utils

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.khlafawi.movieretrofit.MainViewModel
import com.khlafawi.movieretrofit.database.MoviesDataBase

class MainViewModelFactory(
    private val dataSource: MoviesDataBase,
    private val application: Application
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown viewModel class")
    }
}