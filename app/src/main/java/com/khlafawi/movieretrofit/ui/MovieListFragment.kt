package com.khlafawi.movieretrofit.ui

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.khlafawi.movieretrofit.MainViewModel
import com.khlafawi.movieretrofit.database.MoviesDataBase
import com.khlafawi.movieretrofit.databinding.FragmentMoviesListBinding
import com.khlafawi.movieretrofit.utils.MainViewModelFactory

class MovieListFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private val adapter = MoviesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val application: Application = requireNotNull(this.activity).application
        val binding =
            FragmentMoviesListBinding.inflate(
                inflater,
                container,
                false
            )
        binding.moviesRecycler.adapter = adapter

        viewModel =
            ViewModelProviders.of(
                this,
                MainViewModelFactory(
                    MoviesDataBase.getInstance(application),
                    application
                )
            )[MainViewModel::class.java]


        viewModel.topRatedMoviesList.observe(viewLifecycleOwner) {
            it?.let {
                adapter.moviesList = it
            }
        }

        return binding.root
    }
}