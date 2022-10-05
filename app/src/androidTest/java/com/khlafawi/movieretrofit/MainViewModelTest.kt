package com.khlafawi.movieretrofit

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.khlafawi.movieretrofit.data.FakeRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.AutoCloseKoinTest

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainViewModelTest : AutoCloseKoinTest() {

    private lateinit var mainRepository: FakeRepository
    private lateinit var mainViewModel: MainViewModel
    private lateinit var appContext: Application

    @Before
    fun init() {
        appContext = ApplicationProvider.getApplicationContext()
        mainRepository = FakeRepository()
        mainViewModel = MainViewModel(mainRepository, appContext)
    }

    @Test
    fun getAllMoviesTest() {
        GlobalScope.launch {
            mainRepository.refreshData()
            mainViewModel.getTopRatedMovies()
            assertEquals(mainRepository.getAllMoviesList(), mainViewModel.topRatedMoviesList.value)
        }
    }
}