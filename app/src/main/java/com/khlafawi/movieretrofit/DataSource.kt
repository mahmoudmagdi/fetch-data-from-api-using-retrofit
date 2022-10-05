package com.khlafawi.movieretrofit

import com.khlafawi.movieretrofit.model.Movie
import kotlinx.coroutines.flow.Flow

interface DataSource {
    suspend fun refreshData()
    suspend fun getAllMovies(): Flow<List<Movie>>
}