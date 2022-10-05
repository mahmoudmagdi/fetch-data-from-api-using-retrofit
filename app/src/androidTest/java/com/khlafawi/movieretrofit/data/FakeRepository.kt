package com.khlafawi.movieretrofit.data

import com.khlafawi.movieretrofit.DataSource
import com.khlafawi.movieretrofit.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeRepository : DataSource {

    private var insertedMoviesList = arrayListOf<Movie>()

    override suspend fun refreshData() {
        val movieOne = Movie(
            123,
            "test_title",
            "test_poster_path",
            "test_overview"
        )
        val movieTwo = Movie(
            321,
            "test_title",
            "test_poster_path",
            "test_overview"
        )
        insertedMoviesList.add(movieOne)
        insertedMoviesList.add(movieTwo)
    }

    override suspend fun getAllMovies(): Flow<List<Movie>> {
        return flowOf(insertedMoviesList)
    }

    fun getAllMoviesList(): List<Movie> {
        return insertedMoviesList
    }
}