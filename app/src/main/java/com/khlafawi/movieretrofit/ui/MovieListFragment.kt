package com.khlafawi.movieretrofit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.khlafawi.movieretrofit.MainViewModel
import com.khlafawi.movieretrofit.databinding.FragmentMoviesListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()
    private val adapter = MoviesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding =
            FragmentMoviesListBinding.inflate(
                inflater,
                container,
                false
            )
        binding.moviesRecycler.adapter = adapter
        viewModel.topRatedMoviesList.observe(viewLifecycleOwner) {
            it?.let {
                adapter.moviesList = it
            }
        }

        return binding.root
    }
}