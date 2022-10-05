package com.khlafawi.movieretrofit

import android.app.Application
import android.util.Log
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.khlafawi.movieretrofit.data.FakeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.get

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainRepositoryTest : AutoCloseKoinTest() {

    private lateinit var mainRepository: FakeRepository
    private lateinit var appContext: Application

    @Before
    fun init() {
        stopKoin()
        appContext = ApplicationProvider.getApplicationContext()
        val mModule = module {
            single {
                FakeRepository()
            }
        }
        startKoin {
            modules(listOf(mModule))
        }

        mainRepository = get()
    }

    @Test
    fun getAllMoviesTest() {
        Log.e("it", "getAllMoviesTest")
        GlobalScope.launch(Dispatchers.Main) {
            mainRepository.refreshData()
            mainRepository.getAllMovies().collect {
                assertEquals(mainRepository.getAllMoviesList(), it)
            }
        }
    }
}