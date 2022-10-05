package com.khlafawi.movieretrofit

import android.app.Application
import com.khlafawi.movieretrofit.database.MoviesDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        /**
         * use Koin Library as a service locator
         */
        val myModule = module {

            // Declare a ViewModel - be later inject into Fragment with dedicated injector using by viewModel()
            viewModel {
                MainViewModel(
                    get() as DataSource,
                    get()
                )
            }

            single { MainRepository(get()) as DataSource}
            single { MoviesDataBase.getInstance(this@MainApplication) }
        }

        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(myModule))
        }
    }
}