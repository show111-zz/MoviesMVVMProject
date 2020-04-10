package com.example.feature.featurehome.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feature.featurehome.R
import com.example.feature.featurehome.usecase.MovieUseCaseImpl
import com.example.feature.featurehome.viewmodel.MovieVM
import com.example.test.feature_detail.view.MovieDetailFragmentArgs
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_movie_main.*
import kotlinx.android.synthetic.main.fragment_movie_main.view.*
import javax.inject.Inject

class MovieMainFragment : DaggerFragment() {

    @Inject
    lateinit var movieAdapter: MovieAdapter

    @Inject
    lateinit var movieUseCaseImpl: MovieUseCaseImpl

    private lateinit var movieVM: MovieVM

    fun initViewCreated(view: View) {
        movieVM = MovieVM(movieUseCaseImpl).also {
            it.movieState.observe(viewLifecycleOwner, Observer {
                handleMovieState(it, view)
            })
        }

        movieAdapter.onItemClick = { result ->
            navigateToFragmentDestination(result.id)
        }

        movieTitleRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_movie_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewCreated(view)
    }

    private fun handleMovieState(movieState: MovieVM.MovieState, view: View) {
        when (movieState) {
            is MovieVM.MovieState.MovieLoaded -> showMovieData(movieState.items, view)
            is MovieVM.MovieState.Loading -> showLoadingSpinner(view)
            is MovieVM.MovieState.Error -> hideLoadingSpinner(view)
        }
    }

    private fun showLoadingSpinner(view: View) {
        view.loadingSpinner.visibility = View.VISIBLE
    }

    private fun hideLoadingSpinner(view: View) {
        view.loadingSpinner.visibility = View.GONE
    }

    private fun showMovieData(
        items: List<com.example.library.networks.model.Movie>,
        view: View
    ) {
        view.loadingSpinner.visibility = View.GONE
        movieAdapter.updateList(items)
        movieAdapter.notifyDataSetChanged()
    }

    private fun navigateToFragmentDestination(id: Int) {
        val args = MovieDetailFragmentArgs.Builder().setMovieId(id).build().toBundle()
        findNavController().navigate(R.id.detail_feature_graph, args)
    }

}
