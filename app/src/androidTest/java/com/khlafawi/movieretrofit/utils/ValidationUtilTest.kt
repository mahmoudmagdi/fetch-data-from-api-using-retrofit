package com.khlafawi.movieretrofit.utils

import com.khlafawi.movieretrofit.model.Movie
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidationUtilTest {

    @Test
    fun validateMovieTest() {
        val movie = Movie(
            123, "test_title",
            "test_poster_path", "test_overView"
        )
        assertEquals(true, ValidationUtil.validateMovie(movie))
    }

    @Test
    fun validateMovieEmptyTest() {
        val movie = Movie(
            123, "",
            "test_poster_path", ""
        )
        assertEquals(false, ValidationUtil.validateMovie(movie))
    }
}