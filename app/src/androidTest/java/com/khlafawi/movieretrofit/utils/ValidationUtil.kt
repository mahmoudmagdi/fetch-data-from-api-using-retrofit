package com.khlafawi.movieretrofit.utils

import com.khlafawi.movieretrofit.model.Movie

object ValidationUtil {

    fun validateMovie(movie: Movie): Boolean {
        if (movie.title.isNotEmpty() && movie.overview.isNotEmpty()) {
            return true
        }
        return false
    }
}