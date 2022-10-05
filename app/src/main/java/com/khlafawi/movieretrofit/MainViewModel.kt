package com.khlafawi.movieretrofit

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khlafawi.movieretrofit.model.Movie
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepo: DataSource,
    application: Application
) : ViewModel() {

    private val _topRatedMoviesList = MutableLiveData<List<Movie>>()
    val topRatedMoviesList: LiveData<List<Movie>>
        get() = _topRatedMoviesList

    init {
        viewModelScope.launch {
            try {
                mainRepo.refreshData()
                getTopRatedMovies()
            } catch (e: Exception) {
                Log.e("MainViewModel", e.message.toString())
                Toast.makeText(application, "Failure: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun getTopRatedMovies() {
        viewModelScope.launch {
            mainRepo.getAllMovies().collect {
                _topRatedMoviesList.value = it
            }
        }
    }
}