package com.example.moviesmvvmproject.movie.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesmvvmproject.R
import com.example.moviesmvvmproject.movie.model.MovieModelImpl
import com.example.moviesmvvmproject.movie.view.MovieAdapter
import com.example.moviesmvvmproject.movie.viewmodel.MovieVM
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_movie_main.*
import javax.inject.Inject

class MovieMainFragment : DaggerFragment() {

    @Inject
    lateinit var movieAdapter: MovieAdapter

    private val movieVM = MovieVM(MovieModelImpl())

    private val disposeBag = CompositeDisposable()
    private fun Disposable.add() = disposeBag.add(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieAdapter.onItemClick = { result ->
            navigateToFragmentDestination(result.title, result.overview, result.poster_path)
        }

        movieTitleRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = movieAdapter
        }

        movieVM.movies
            .subscribe { results ->
                movieAdapter.updateList(results)
                movieAdapter.notifyDataSetChanged()
            }
            .add()
    }

    private fun navigateToFragmentDestination(
        title: String,
        overview: String,
        posterPath: String
    ) {
        val directions =
            MovieMainFragmentDirections.actionMainFragmentToDestinationFragment().setMovieTitle(title).setDescription(overview).setPosterUrl(posterPath)
        findNavController().navigate(directions)
    }

}
