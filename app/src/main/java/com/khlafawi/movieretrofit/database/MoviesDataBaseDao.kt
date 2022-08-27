package com.khlafawi.movieretrofit.database

import androidx.room.*
import com.khlafawi.movieretrofit.model.Movie
import kotlinx.coroutines.flow.Flow

@Dao
interface MoviesDataBaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg manyMovies: Movie)

    @Query("SELECT * FROM movies_table")
    fun getAllMovies(): Flow<List<Movie>>
}