package com.khlafawi.movieretrofit

import com.khlafawi.movieretrofit.api.RetrofitBuilder
import com.khlafawi.movieretrofit.database.MoviesDataBase
import com.khlafawi.movieretrofit.model.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository(private val database: MoviesDataBase) {

    suspend fun refreshData() {
        withContext(Dispatchers.IO) {
            val response = RetrofitBuilder.retrofitService.getTopRatedMoviesAsync().await()
            database.moviesDatabaseDao.insertAll(*response.results.asDatabaseModel())
        }
    }
}