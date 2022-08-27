package com.khlafawi.movieretrofit.api

import com.khlafawi.movieretrofit.utils.Constants.API_KEY
import com.khlafawi.movieretrofit.model.MoviesResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

// TODO: STEP(4): build the retrofit interface with required functions
interface ApiInterface {

    @GET("3/movie/top_rated")
    fun getTopRatedMoviesAsync(@Query("api_key") apiKey: String = API_KEY): Deferred<MoviesResponse>
}
// TODO: STEP(4): build the retrofit interface with required functions